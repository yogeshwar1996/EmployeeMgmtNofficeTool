import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.*;
import java.lang.Object;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Employee_info extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

public Employee_info() {
        initComponents();
        conn=javaconnect.ConnectDb();
        Update_table();
        Fillcombo();
        CurrentDate();
    }
    //method to get the screen shot 
    public static BufferedImage getScreenShot(Component component){
    BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
    component.paint(image.getGraphics());
    return image;
      
    }
    //method to save the screen shot
    public static void SaveScreenShot(Component component,String filename) throws Exception
    {
    BufferedImage img = getScreenShot(component);
    ImageIO.write(img,"png",new File(filename));
    
    }
    
    public void comboselect() //this code is to open a new jframe by clicking at an item in combobox
    {
        int d = goto_combobox.getSelectedIndex();//here combobox item is selected based on its index
        if(d == 2)                               //this method works with both the values of combobox initialised in properties
        {                                    //as well as values stored in the database   
        dispose();
        Userinfo_frame s = new Userinfo_frame();
        s.setVisible(true);
        
        }
    
                             //here combobox item is selected based on its content i.e string value
                             //this method works with  values of combobox initialised in properties only
        if(goto_combobox.getSelectedItem()== "Login")// works
        {dispose();
        Login_jframe y = new Login_jframe();
        y.setVisible(true);
        }    
    }
    
    public void CurrentDate(){
    Thread clock = new Thread(){
    public void run(){
    for(;;){
    Calendar cal = new GregorianCalendar();
    int month =cal.get(Calendar.MONTH);
    int year=cal.get(Calendar.YEAR);
    int day=cal.get(Calendar.DAY_OF_MONTH);
    date_txt.setText("Date "+year+"/"+(month+1)+"/"+day);
    
    int second =cal.get(Calendar.SECOND);
    int minute=cal.get(Calendar.MINUTE);
    int hour=cal.get(Calendar.HOUR);
    int am_pm=cal.get(Calendar.AM_PM);
    String ap = am_pm==1?"PM":"AM";
    txt_time.setText("Time "+hour+":"+minute+":"+second+" "+ap);
            try {
            sleep(1000);
            }catch (InterruptedException ex) 
            {
                Logger.getLogger(Employee_info.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        };
        clock.start();
    }
    public void close()
    {
    WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    private void Update_table()
    {
        try
        {
            String sql="select employeeid as 'EMP_ID',name as 'NAME',surname as 'SURNAME',age as 'AGE', username as 'USER_NAME',password as 'PASS_WORD',image as 'IMAGE',gender as 'GENDER' from Employeeinfo order by '"+order+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
    }
    
    private void Fillcombo()
    {
        try
        {                  
            String sql="select * from Employeeinfo";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                String field=rs.getString("name");//in the "" write th name of the field whose contents u want to get displayed in commbox
                ComboBox_name.addItem(field);//pass variable of type String in above statement to the assItem function
            }     
        }
        catch(Exception e)
           {
            JOptionPane.showMessageDialog(null,e);
            }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        sort_group = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        My_Panel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cmd_delete = new javax.swing.JButton();
        cmd_clear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_update = new javax.swing.JButton();
        cmd_save = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        search_panel = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Employee = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_age = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_surname = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_Employeeid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        ComboBox_name = new javax.swing.JComboBox<>();
        goto_combobox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        image = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        date_txt = new javax.swing.JMenu();
        txt_time = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.PNG"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        My_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 51), 5));

        jButton3.setText("Image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bradley Hand ITC", 1, 18), new java.awt.Color(102, 255, 0))); // NOI18N

        cmd_delete.setBackground(new java.awt.Color(255, 204, 102));
        cmd_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recycle-Bin-full-icon.png"))); // NOI18N
        cmd_delete.setText("Delete");
        cmd_delete.setToolTipText("To Delete the entry from table");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        cmd_clear.setBackground(new java.awt.Color(255, 204, 102));
        cmd_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-draw-eraser-icon.png"))); // NOI18N
        cmd_clear.setText("Clear");
        cmd_clear.setToolTipText("Clears the Data Filed Box");
        cmd_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_clearActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New-file-icon.png"))); // NOI18N
        jButton2.setText("Next");
        jButton2.setToolTipText("Opens a New JFrame");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_update.setBackground(new java.awt.Color(255, 204, 102));
        txt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-document-edit-icon.png"))); // NOI18N
        txt_update.setText("Update");
        txt_update.setToolTipText("Modifies the entry in table");
        txt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateActionPerformed(evt);
            }
        });

        cmd_save.setBackground(new java.awt.Color(255, 204, 102));
        cmd_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save-icon.png"))); // NOI18N
        cmd_save.setText("save");
        cmd_save.setToolTipText("To Insert and Save a new entry");
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });

        cmd_print.setBackground(new java.awt.Color(255, 204, 102));
        cmd_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon.png"))); // NOI18N
        cmd_print.setText("Print");
        cmd_print.setToolTipText("Prints the Table in a PDF format");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setText("<html> <font color=\"red\">iTxtReport</font> </html>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 153, 0));
        jButton7.setText("FrameCapture");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText(" Name Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setText("Age order");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("ID order");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cmd_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_delete)
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_print)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        search_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Old English Text MT", 1, 18), new java.awt.Color(102, 0, 102))); // NOI18N

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout search_panelLayout = new javax.swing.GroupLayout(search_panel);
        search_panel.setLayout(search_panelLayout);
        search_panelLayout.setHorizontalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        search_panelLayout.setVerticalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Table_Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_EmployeeMouseClicked(evt);
            }
        });
        Table_Employee.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Table_EmployeePropertyChange(evt);
            }
        });
        Table_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table_EmployeeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table_EmployeeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Employee);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Field", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 153, 0))); // NOI18N

        txt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ageActionPerformed(evt);
            }
        });
        txt_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ageKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Age");

        txt_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_surnameActionPerformed(evt);
            }
        });

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_Employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmployeeidActionPerformed(evt);
            }
        });
        txt_Employeeid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EmployeeidKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Employeeid");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Surname");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_name)
                                .addComponent(txt_Employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_surname)
                                .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton4.setText("Attach Image");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Combobox", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(153, 153, 0))); // NOI18N

        ComboBox_name.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboBox_namePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        ComboBox_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_nameActionPerformed(evt);
            }
        });

        goto_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Goto>", "Login", "User_Info" }));
        goto_combobox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                goto_comboboxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        goto_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goto_comboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBox_name, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addComponent(goto_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBox_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goto_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ORDER BY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vivaldi", 1, 14), new java.awt.Color(0, 153, 51))); // NOI18N

        sort_group.add(jRadioButton3);
        jRadioButton3.setText("Name");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        sort_group.add(jRadioButton4);
        jRadioButton4.setText("Age");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        sort_group.add(jRadioButton5);
        jRadioButton5.setText("ID");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(85, 85, 85))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout My_PanelLayout = new javax.swing.GroupLayout(My_Panel);
        My_Panel.setLayout(My_PanelLayout);
        My_PanelLayout.setHorizontalGroup(
            My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(My_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(My_PanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(My_PanelLayout.createSequentialGroup()
                                .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(My_PanelLayout.createSequentialGroup()
                                .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                        .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(My_PanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(My_PanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(4, 4, 4))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        My_PanelLayout.setVerticalGroup(
            My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(My_PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(My_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, My_PanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(My_PanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(My_PanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.PNG"))); // NOI18N
        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        date_txt.setText("Date");
        jMenuBar1.add(date_txt);

        txt_time.setText("Time");
        jMenuBar1.add(txt_time);

        jMenu3.setText("Help");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Help File");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(My_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(My_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jButton1))
        );

        setSize(new java.awt.Dimension(1334, 632));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_nameActionPerformed

        
    }//GEN-LAST:event_ComboBox_nameActionPerformed

    private void txt_EmployeeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmployeeidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmployeeidActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_surnameActionPerformed

    private void txt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageActionPerformed

    private void Table_EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_EmployeeMouseClicked
        int row=Table_Employee.getSelectedRow();
        String Table_click=(Table_Employee.getModel().getValueAt(row,0).toString());
          
        // TODO add your handling code here:for image
        try{
        String sql ="select image from Employeeinfo where employeeid= '"+ Table_click +"'  ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next())
        {
        byte[] imagedata = rs.getBytes("image");
        if(imagedata==null)
        {  try{
           rs.close();
           pst.close();
           String sql_="select image from Employeeinfo where Employeeid=1000";
           pst=conn.prepareStatement(sql_);
           rs=pst.executeQuery();
           byte[] imagedata_ = rs.getBytes("image");
           format = new ImageIcon(imagedata_);
           image.setIcon(format);
           }
           catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        }
        else
        {
           format = new ImageIcon(imagedata);
           image.setIcon(format);
        }    
        }
        }
        
        catch(Exception e){e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        
        //originally starts here:
        try
        {   //int row=Table_Employee.getSelectedRow();
            //String Table_click=(Table_Employee.getModel().getValueAt(row,0).toString());
            String sql="select * from Employeeinfo where Employeeid='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
            String add1=rs.getString("Employeeid");
            txt_Employeeid.setText(add1);
            String add2=rs.getString("name");
            txt_name.setText(add2);
            String add3=rs.getString("surname");
            txt_surname.setText(add3);
            String add4=rs.getString("age");
            txt_age.setText(add4);
            gender=rs.getString("gender");
            }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);
        }
         finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
    }//GEN-LAST:event_Table_EmployeeMouseClicked

    private void ComboBox_namePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBox_namePopupMenuWillBecomeInvisible
        
        String tmp=(String)ComboBox_name.getSelectedItem();
        String sql="select * from Employeeinfo where name=?"; //use the phrase after 'where' in the query same as you chose in fillcombo()
        try{
        pst=conn.prepareStatement(sql);
        pst.setString(1,tmp);
        rs=pst.executeQuery();
        if(rs.next())
        {
            String add1=rs.getString("Employeeid");
            txt_Employeeid.setText(add1);
            String add2=rs.getString("name");
            txt_name.setText(add2);
            String add3=rs.getString("surname");
            txt_surname.setText(add3);
            String add4=rs.getString("age");
            txt_age.setText(add4);
           
   
                }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
    
    }//GEN-LAST:event_ComboBox_namePopupMenuWillBecomeInvisible

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
            try
            {
                String sql="Insert into Employeeinfo (employeeid,name,surname,age,image,gender) values (?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1,txt_Employeeid.getText());
                pst.setString(2,txt_name.getText());
                pst.setString(3,txt_surname.getText());
                pst.setString(4,txt_age.getText());
                pst.setBytes(5,person_image);
                pst.setString(6,gender);
                pst.execute();
                JOptionPane.showMessageDialog(null, "saved");
                Update_table();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }

    }//GEN-LAST:event_cmd_saveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
         
         dispose();
         
        new Userinfo_frame().setVisible(true);
                
        //close();
        /*
        Update_table();
        Userinfo_frame s= new Userinfo_frame();
        s.setVisible(true);*/
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
        
        int p = JOptionPane.showConfirmDialog(null,"Do you surely want to delete","Delete",JOptionPane.YES_NO_OPTION);
        if(p== 0){
        String sql="delete from Employeeinfo where employeeid=?";
               
        try{
        pst=conn.prepareStatement(sql);
        
        pst.setString(1,txt_Employeeid.getText());
        
        pst.execute();
              
            JOptionPane.showMessageDialog(null, "Deleted");
            
            Update_table();
        }   
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        }
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void txt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateActionPerformed
        // TODO add your handling code here:
        try{
        String value1=txt_Employeeid.getText();
        String value2=txt_name.getText();
        String value3 =txt_surname.getText();
        String value4=txt_age.getText();
        String value5=gender;
        String sql="update Employeeinfo set employeeid='"+value1+"', name='"+value2+"' ,surname='"+value3+"',age='"+value4+"',gender='"+value5+"' where employeeid='"+value1+"' ";
        pst=conn.prepareStatement(sql);
        pst.execute();
       
                 JOptionPane.showMessageDialog(null, "Updated");
          Update_table();
                
        }
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
    }//GEN-LAST:event_txt_updateActionPerformed

    private void cmd_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_clearActionPerformed
        txt_Employeeid.setText("");
        txt_name.setText("");
        txt_surname.setText("");
        txt_age.setText("");
        path.setText("");
        Update_table();

    }//GEN-LAST:event_cmd_clearActionPerformed

    private void Table_EmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_EmployeeKeyPressed
       /*This Also Works but better to use Key Released Version 
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
        try
        { int row=Table_Employee.getSelectedRow();
            String Table_click=(Table_Employee.getModel().getValueAt(row+1,0).toString());
            String sql="select * from Employeeinfo where Employeeid='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
            String add1=rs.getString("Employeeid");
            txt_Employeeid.setText(add1);
            String add2=rs.getString("name");
            txt_name.setText(add2);
            String add3=rs.getString("surname");
            txt_surname.setText(add3);
            String add4=rs.getString("age");
            txt_age.setText(add4);
            }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);}
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        }
        if(evt.getKeyCode()==KeyEvent.VK_UP){
        try
        {   int row=Table_Employee.getSelectedRow();
            String Table_click=(Table_Employee.getModel().getValueAt(row-1,0).toString());
            String sql="select * from Employeeinfo where Employeeid='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
            String add1=rs.getString("Employeeid");
            txt_Employeeid.setText(add1);
            String add2=rs.getString("name");
            txt_name.setText(add2);
            String add3=rs.getString("surname");
            txt_surname.setText(add3);
            String add4=rs.getString("age");
            txt_age.setText(add4);
            }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);}
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        }
        
      */
    }//GEN-LAST:event_Table_EmployeeKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       try{
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"javabook.pdf");
        
        }
                catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try{
            Table_Employee.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        } catch(java.awt.print.PrinterException e)
        {
            
            System.err.format("Cannot print %s%n",e.getMessage());
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }

    }//GEN-LAST:event_cmd_printActionPerformed

    private void goto_comboboxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_goto_comboboxPopupMenuWillBecomeInvisible
     comboselect();
    }//GEN-LAST:event_goto_comboboxPopupMenuWillBecomeInvisible

    private void goto_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goto_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goto_comboboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Basic code to display image stored in the data base
        try{
        String sql ="select image from Employeeinfo where employeeid=1";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        byte[] imagedata = rs.getBytes("image");
        format = new ImageIcon(imagedata);
        image.setIcon(format);
        }
        
        }catch(Exception e){e.printStackTrace();}
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Table_EmployeePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Table_EmployeePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_Table_EmployeePropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       JFileChooser Chooser = new JFileChooser();
       Chooser.showOpenDialog(null);
       
       /*Code to attach the File*/
       File f = Chooser.getSelectedFile();       
       filename = f.getAbsolutePath();
       path.setText(filename);
       try{
       File image = new File(filename);
       FileInputStream fis = new FileInputStream(image);
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
       byte[] buf = new byte[1024];
       for(int readNum;(readNum=fis.read(buf))!= -1;){
       bos.write(buf,0,readNum);
       }
       person_image=bos.toByteArray();
       }
       catch(Exception e){JOptionPane.showMessageDialog(null, e);}
       

    }//GEN-LAST:event_jButton4ActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        gender = "Male";
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        gender="Female";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void Table_EmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_EmployeeKeyReleased

        if(evt.getKeyCode()==KeyEvent.VK_DOWN  || evt.getKeyCode()==KeyEvent.VK_UP){
        try{
            int row=Table_Employee.getSelectedRow();
            String Table_click=(Table_Employee.getModel().getValueAt(row,0).toString());
            String sql="select * from Employeeinfo where Employeeid='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
            String add1=rs.getString("Employeeid");
            txt_Employeeid.setText(add1);
            String add2=rs.getString("name");
            txt_name.setText(add2);
            String add3=rs.getString("surname");
            txt_surname.setText(add3);
            String add4=rs.getString("age");
            txt_age.setText(add4);
            //for image
             byte[] imagedata = rs.getBytes("image");
             if(imagedata==null)
             {
             try{
              String sql_="select image from Employeeinfo where Employeeid=1000";
              rs.close();
              pst.close();        
              pst=conn.prepareStatement(sql_);
              rs=pst.executeQuery();
              byte[] imagedata_ = rs.getBytes("image");
              format = new ImageIcon(imagedata_);
              image.setIcon(format);
              }
             catch(Exception e){JOptionPane.showMessageDialog(null,e);}
             }
             else
             {
               format = new ImageIcon(imagedata);
               image.setIcon(format);
              }    
            }
        }
       /* catch(Exception e){JOptionPane.showMessageDialog(null, e);}*/
        catch(Exception e){e.printStackTrace();}//catch specially used for exception ocuured due to image
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        }
        
    }//GEN-LAST:event_Table_EmployeeKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            /*1.select an entry from table in Userinfo frame
              2.select an generate pie chart from insert and charts panel in tabbed pane
              3.Go back to the Employeeinfo pane and select an entry of employeeid same as pumpid u have chosen 
                and then click to generate the ireport*/

        //note while fixing imports here carefully choose import com.itextpdf.text.Document;
        //import com.itextpdf.text.pdf.PdfWriter;
        
       /*Code to combine two pdf reports originial 
        try{
        PdfReader report_var = new PdfReader("Report1.pdf");
        PdfReader report_var1 = new PdfReader("Report2.pdf");
        PdfCopyFields copy = new PdfCopyFields(new FileOutputStream("Joined Report.pdf"));
        copy.addDocument(report_var);
        copy.addDocument(report_var1);
        copy.close();
        JOptionPane.showMessageDialog(null,"combined report saved");
        }catch(Exception e){};
        */
        String value1=txt_Employeeid.getText();
        String value2=txt_name.getText();
        String value3=txt_surname.getText();
        String value4=txt_age.getText();
        
        
        
        try{
            Document document = new Document();
            
           PdfWriter  writer = PdfWriter.getInstance(document,new FileOutputStream("Report"+value1+".pdf"));
           document.open();
           /*Barcode at top
           PdfContentByte CB =writer.getDirectContent();
           BarcodeEAN codEAN = new BarcodeEAN();
           codEAN.setCode("");
           Paragraph para = new Paragraph("123456789012");
           document.add(new Paragraph("Barcode UDCA"));
           codEAN.setCodeType(Barcode.UPCA);
           codEAN.setCode("123456789012");
           document.add(codEAN.createImageWithBarcode(CB, BaseColor.BLACK, BaseColor.BLACK));
           document.add(para);
           */
            document.add(new Paragraph("Image"));//image title
            Image image = Image.getInstance("screenshot_pic"+value1+".png");//to add image
            document.add(image);
            
            //to print hello world and chosing font type,size and color
            document.add(new Paragraph("Hello World",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.RED)));
            
            //to add Date
            document.add(new Paragraph(new Date().toString()));
            
            //simple to ad text
            document.add(new Paragraph("---------------------------------------Emploee_INFO Table----------------------------------------------"));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------"));
            //to add table
            PdfPTable table = new PdfPTable(4);//Value PdfPtable(x) means we want x column(s)
            
            //to add custom cell
          /*  PdfPCell cell = new PdfPCell(new Paragraph("Title:Employee_info"));// title cell
            cell.setColspan(1);//tells the width to be set for a column
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);//aligning the cell             
            cell.setBackgroundColor(BaseColor.GREEN);//background color of cell
            table.addCell(cell);*/
            
            //to add other data cells
            table.addCell("Emploee_ID");
            table.addCell("F_Name");
            table.addCell("L_Name");
            table.addCell("Age");
            
            table.addCell(value1);
            table.addCell(value2);
            table.addCell(value3);
            table.addCell(value4);
            
            
            document.add(table);
            
            com.itextpdf.text.List list = new com.itextpdf.text.List(true,20);//true means you want numbering 20 means maxitems
                                                                                           
            list.add("First Itm");                                  
            list.add("Second Itm");
            list.add("Third Itm");
            list.add("Fourth Itm");
            document.add(list);
            JOptionPane.showMessageDialog(null,"Report Saved");
            
            //code to show pie chart png image in the report
            document.add(new Paragraph("PIE CHART"));//image title
            Image pie = Image.getInstance("chart"+value1+".png");//to add image
            pie.scaleAbsolute(520,400);//size of image in report
            document.add(pie);
           
            /*Barcode in the End*/ 
            
           PdfContentByte CB =writer.getDirectContent();
           BarcodeEAN codEAN = new BarcodeEAN();
           codEAN.setCode("");
           Paragraph para = new Paragraph("123456789012");
           document.add(new Paragraph("Barcode UDCA"));
           codEAN.setCodeType(Barcode.UPCA);
           codEAN.setCode("123456789012");
           document.add(codEAN.createImageWithBarcode(CB, BaseColor.BLACK, BaseColor.BLACK));
           document.add(para);
           
            document.close();
         
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,e);}       
//        finally{try{rs.close();pst.close();}catch(Exception e){JOptionPane.showMessageDialog(null,e);}}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String name_pic = txt_Employeeid.getText();
    
        try{SaveScreenShot(My_Panel,"screenshot.png");
            SaveScreenShot(search_panel,"screenshot_search.png");
            SaveScreenShot(image,"screenshot_pic"+name_pic+".png");}
        catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        try{
            String sql="select * from Employeeinfo where name=? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("employeeid");
                txt_Employeeid.setText(add1);
                String add2=rs.getString("name");
                txt_name.setText(add2);
                String add3=rs.getString("surname");
                txt_surname.setText(add3);
                String add4=rs.getString("age");
                txt_age.setText(add4);

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
        }
        try{
            String sql="select * from Employeeinfo where employeeid=? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("employeeid");
                txt_Employeeid.setText(add1);
                String add2=rs.getString("name");
                txt_name.setText(add2);
                String add3=rs.getString("surname");
                txt_surname.setText(add3);
                String add4=rs.getString("age");
                txt_age.setText(add4);

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
        }

        try{
            String sql="select * from Employeeinfo where surname=? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("employeeid");
                txt_Employeeid.setText(add1);
                String add2=rs.getString("name");
                txt_name.setText(add2);
                String add3=rs.getString("surname");
                txt_surname.setText(add3);
                String add4=rs.getString("age");
                txt_age.setText(add4);

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
        }

    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_EmployeeidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EmployeeidKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_EmployeeidKeyTyped

    private void txt_ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ageKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageKeyTyped

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        order="EMP_ID";
        Update_table();
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        order="AGE";
        Update_table();

    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        order="NAME";
        Update_table();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try
        {
            String sql="select employeeid as 'EMP_ID',name as 'NAME',surname as 'SURNAME',age as 'AGE', username as 'USER_NAME',password as 'PASS_WORD',image as 'IMAGE',gender as 'GENDER' from Employeeinfo order by age ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        order="age";
        Update_table();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try
        {
            String sql="select employeeid as 'EMP_ID',name as 'NAME',surname as 'SURNAME',age as 'AGE', username as 'USER_NAME',password as 'PASS_WORD',image as 'IMAGE',gender as 'GENDER' from Employeeinfo order by name ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
        order="name";
        Update_table();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
                try
        {
            String sql="select employeeid as 'EMP_ID',name as 'NAME',surname as 'SURNAME',age as 'AGE', username as 'USER_NAME',password as 'PASS_WORD',image as 'IMAGE',gender as 'GENDER' from Employeeinfo order by employeeid ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
            }
         }
                order="employeeid";
                Update_table();
    }//GEN-LAST:event_jButton9ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                           // UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                              UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                                 //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.AeroLookAndFeel");
                             //    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.AluminiumLookAndFeel");
                            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.BernsteinLookAndFeel");
                            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.FastLookAndFeel");
                            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.GraphiteLookAndFeel");
                           // UIManager.setLookAndFeel("com.jtattoo.plaf.smart.HiFiLookAndFeel");

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_name;
    private javax.swing.JPanel My_Panel;
    private javax.swing.JTable Table_Employee;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmd_clear;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_print;
    private javax.swing.JButton cmd_save;
    private javax.swing.JMenu date_txt;
    private javax.swing.JComboBox<String> goto_combobox;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField path;
    private javax.swing.JPanel search_panel;
    private javax.swing.ButtonGroup sort_group;
    private javax.swing.JTextField txt_Employeeid;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_surname;
    private javax.swing.JMenu txt_time;
    private javax.swing.JButton txt_update;
    // End of variables declaration//GEN-END:variables

private ImageIcon format = null;
String filename = null;
int s=0;
byte[] person_image=null;
private String gender;
private String order;
        

}

