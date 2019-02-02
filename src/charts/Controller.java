package charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public class Controller {
    private ObservableList<PieChart.Data> dlist;
    
// Gráficos
    private @FXML BarChart barChart;
    private @FXML LineChart<?, ?> lineChart;
    private @FXML PieChart pieChart;
    private @FXML AreaChart areaChart;
    private @FXML StackedAreaChart stockedAreaChart;
    
    // Tabs
    @FXML Tab tabBar;
    @FXML Tab tabLine;
    @FXML Tab tabPie;
    @FXML Tab tabArea;
    @FXML Tab tabStockedArea;
    @FXML Label lbl;
    
    private PieChart.Data pieData;
    private Series series1;
    private Series series2;
    private Series series3;
    
    public void setData() {
        
        dlist = FXCollections.observableArrayList();
        
        series1 = new Series();
        series2 = new Series();
        series3 = new Series();
        
        for (int i = -5000; i < 5000; i += 100) {
            series1.getData().add(new XYChart.Data(i*i*i - i*i, 3*i*i - 100*i +30));
            series2.getData().add(new XYChart.Data(""+i, i*i*i - i*i));
            series3.getData().add(new XYChart.Data(""+i, 3*(i*i*i) + i*i +400));
           
            dlist.clear();
            dlist.add(new PieChart.Data("1", 3*i*i - 100*i +30 ));
            dlist.add(new PieChart.Data("2", i*i*i - i*i ));
            dlist.add(new PieChart.Data("3", 3*(i*i*i) + i*i +400));
        }

        switch(lbl.getText()){
            case "barras":
                barChart.getData().clear();
                barChart.getData().addAll( series2, series3);
                break;
            case "lineas":
                lineChart.getData().clear();
                lineChart.getData().addAll( series2, series3);
                break;
            case "pie":
                pieChart.setData(dlist);
                // ...
                break;
            case "area":
                areaChart.getData().clear();
                areaChart.getData().addAll( series2, series3);
                break;
            case "stkArea":
                stockedAreaChart.setData(FXCollections.observableArrayList(series1));
//                stockedAreaChart.getData().addAll(series1,series2,series3);
                // ...
                break;
        }
    }
    
    // si se agregan los datos en todos los gráficos al mismo tiempo, se dibujan mal
    public void bar(){
        lbl.setText("barras");
        setData();
    }
    public void line(){
        lbl.setText("lineas");
        setData();
    }
    public void pie(){
        lbl.setText("pie");
        setData();
    }
    public void area(){
        lbl.setText("area");
        setData();
    }
    public void stkArea(){
        lbl.setText("stkArea");
        setData();
    }
}
