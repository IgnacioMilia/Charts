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
    private @FXML LineChart lineChart;
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

    public void setData() {
        dlist = FXCollections.observableArrayList();

        for (int i = -10; i < 10; i ++) {
           dlist.add(new XYChart.Data("assss"+ i, -2 * (i*i*i) + 10 * (i*i) - 33 ));
        }
        
        ObservableList datos = FXCollections.observableArrayList( new Series(dlist));
        // cómo agregar más funciones?
        ObservableList datos2 = FXCollections.observableArrayList( datos);
        
        switch(lbl.getText()){
            case "barras":
                barChart.setData(datos);
                break;
            case "lineas":
                lineChart.setData(datos);
                break;
            case "pie":
                // ...
                break;
            case "area":
                areaChart.setData(datos);
                break;
            case "stkArea":
                // ...
                break;
        }
    }
    
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
