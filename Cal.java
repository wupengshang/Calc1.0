import java.awt.*;
import java.awt.event.*;

public class Cal{

    public static void main(String[] args){
        CalculaterGui c1 = new CalculaterGui("Calc 1.0");
    }
}

 class CalculaterGui extends Frame {

    final Panel panel = new Panel();
    //final Panel clear = new Panel();
    final Label label = new Label();
    private double first_num = 0;
    private double second_num = 0;
    private double result = 0;
    private int  symbol = 0;
    private boolean finish = false;
    final String names[] = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
    final Button[] buttons = new Button[16];
    final Button clear = new Button("Clear");

    public CalculaterGui(String name){
        super(name);
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent eve){
                for(int i = 0;i < buttons.length;i++){
                    if(eve.getSource() == buttons[i]){
                        if(finish == true || label.getText() == "Clear"){
                            label.setText("");
                            finish = false;
                        }
                        switch (i){
                            case 0:
                            case 1:
                            case 2:
                            case 4:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                                label.setText(label.getText() + buttons[i].getLabel());
                            break;
                            case 3:
                            case 7:
                            case 11:
                            case 15:
                                first_num = Double.valueOf(label.getText());
                                label.setText("");//clear the label
                                symbol = i;
                            break;
                            case 14:
                                second_num = Double.valueOf(label.getText());
                                finish = true;
                                switch(symbol){
                                    case 3://sum
                                        label.setText(Double.toString(first_num + second_num));
                                    break;
                                    case 7://minus
                                        label.setText(Double.toString(first_num - second_num));
                                    break;
                                    case 11://product
                                        label.setText(Double.toString(first_num * second_num));
                                    break;
                                    case 15://division
                                        label.setText(Double.toString(first_num / second_num));
                                    break;
                                    default:
                                    		//finish = false;
                                    break;
                                    //symbol = 0;
                                }
                                symbol = 0;
                            break;
                        }
                    }
                }
            }
    };
    ActionListener settings = new ActionListener(){
        public void actionPerformed(ActionEvent click){
            first_num = 0;
            second_num = 0;
            finish = false;
            symbol = 0;
            label.setText("Clear");
        }
    };

        GridLayout grid1 = new GridLayout(4,4);
        panel.setLayout(grid1);
        for(int j=0;j<buttons.length;j++){
            buttons[j] = new Button(names[j]);
            panel.add(buttons[j]);
            buttons[j].addActionListener(listener);
        }
        clear.addActionListener(settings);
        //BorderLayout border = (BorderLayout)this.getLayout();
        this.add(label,"North");
        this.add(panel,"Center");
        this.add(clear,"South");
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent eve){
                System.exit(0);
            }
        });
        setSize(300,320);
        setVisible(true);

    }




}
