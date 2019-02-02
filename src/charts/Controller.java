package charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
// 

public class Controller {
    private ObservableList<XYChart.Series> slist;
    private ObservableList<XYChart.Data> dlist;
    
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
    
    private XYChart.Series series1;
    private XYChart.Series series2;
    
    public void setData() {
        dlist = FXCollections.observableArrayList();
        
        series1 = new Series();
        series2 = new Series();
        Series series3 = new Series();
        
        
        for (int i = -5000; i < 5000; i += 500) {
            series1.getData().add(new XYChart.Data(""+i, 3*i*i - 100*i +30));
            series2.getData().add(new XYChart.Data(""+i, i*i*i - i*i));
            series3.getData().add(new XYChart.Data(""+i, 3*(i*i*i) + i*i +400));
            //dlist.add(new XYChart.Data("assss", -3 * (i*i*i) + 5 * (i*i) - 1 ));
           //dlist.add(new XYChart.Data("assss2", 3 * (i*i*i) - 5 * (i*i) - 1 ));
        }
        
//        ObservableList datos = FXCollections.observableArrayList(dlist);
        // cómo agregar más funciones?
        //ObservableList datos2 = FXCollections.observableArrayList( datos);
        
//        lineChart.
        switch(lbl.getText()){
            case "barras":
                barChart.getData().clear();
                barChart.getData().addAll(series1, series2, series3);
                break;
            case "lineas":
                lineChart.getData().clear();
                lineChart.getData().addAll(series1, series2, series3);
                break;
            case "pie":
                // ...
                break;
            case "area":
                areaChart.getData().clear();
                areaChart.getData().addAll(series1, series2, series3);
                break;
            case "stkArea":
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
