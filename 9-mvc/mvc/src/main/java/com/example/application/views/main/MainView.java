package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.*;

// import javax.swing.GroupLayout.Alignment;

@PageTitle("Employee Directory")
@Route(value = "")
public class MainView extends VerticalLayout {

    private TextField id, name, id1, id2, idsub;
    private Button getsub, addemp, seeemps;
    private Grid<Employee> grid;
    private EmpController controller = new EmpController();

    public MainView() {
        setMargin(true);

        seeemps = new Button("See Employees");
        seeemps.addClickListener(e -> {
            Dialog dialog = new Dialog();
            grid = new Grid<>();
            grid.setItems(controller.getEmployees());
            grid.addColumn(Employee::getId).setHeader("ID");
            grid.addColumn(Employee::getName).setHeader("Name");
            dialog.setHeaderTitle("Employees");
            dialog.add(grid);
            dialog.setWidth("80%");
            dialog.open();
        });

        id = new TextField("Employee ID");
        name = new TextField("Employee Name");
        addemp = new Button("Add Employee");
        addemp.addClickListener(e -> {
            controller.addEmployee(Integer.parseInt(id.getValue()), name.getValue());
            Notification.show("Employee added");
        });
        addemp.addClickShortcut(Key.ENTER);
        HorizontalLayout id_name_input_layout = new HorizontalLayout();
        id_name_input_layout.add(id, name, addemp);


        idsub = new TextField("Employee ID");
        getsub = new Button("Get Subordinates");
        getsub.addClickListener(e -> {
            Dialog dialog = new Dialog();
            List<String> names = controller.getSubordinatesNames(Integer.parseInt(idsub.getValue()));
            VerticalLayout layout = new VerticalLayout();
            for (String name : names) {
                TextField n = new TextField();
                n.setReadOnly(true);
                n.setValue(name);
                layout.add(n);
            }
            dialog.setHeaderTitle("Subordinates of Employee " + idsub.getValue());
            dialog.add(layout);
            dialog.setWidth("80%");
            dialog.open();            
        });
        getsub.addClickShortcut(Key.ENTER);
        HorizontalLayout addemp_getsub_button_layout = new HorizontalLayout();
        addemp_getsub_button_layout.add(idsub, getsub);

        id1 = new TextField("Manager ID");
        id2 = new TextField("Subordinate ID");
        Button addsub = new Button("Add Subordinate");
        addsub.addClickListener(e -> {
            controller.addSubordinate(Integer.parseInt(id1.getValue()), Integer.parseInt(id2.getValue()));
            Notification.show("Subordinate " + id2.getValue() + " added to manager " + id1.getValue());
        });
        HorizontalLayout id1_id2_input_layout = new HorizontalLayout();
        id1_id2_input_layout.add(id1, id2, addsub);

        add(seeemps, id_name_input_layout, addemp_getsub_button_layout, id1_id2_input_layout);

    }

}
