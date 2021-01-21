package com.company;
import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//jframe sınıfını kalıtan ve actionlistener interface'sini kullanan yoneticitablo sınıfı.
//actionlistener interface'sinin kullanılabilmesi için actionperformed metodu kullanılmalıdır.
public class YoneticiTablo extends JFrame implements ActionListener{
    JPanel panel1;
    JTable tablo;
    JScrollPane jsn1;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    JLabel lbl1,lbl2;

    //yoneticitablo constructoru. frame oluşturuluyor.
    //tüm işlemler tek frame üzerinden yürütülecek. basit bir tasarım.
    YoneticiTablo(){
        panel1 = new JPanel(null);
        setSize(500, 500);
        tablo=new JTable();

        lbl1=new JLabel("Kullanıcı İşlemleri");
        lbl1.setBounds(400,0,100,20);
        add(lbl1);

        lbl2=new JLabel("Yönetici İşlemleri");
        lbl2.setBounds(115,170,100,20);
        add(lbl2);

        btn1=new JButton("Çıkış");
        btn1.setBounds(475,340,100,30);
        add(btn1);
        btn1.addActionListener(this);

        btn2=new JButton("Stok-artan");
        btn2.setBounds(350,20,100,30);
        add(btn2);
        btn2.addActionListener(this);

        btn3=new JButton("Stok-azalan");
        btn3.setBounds(455,20,100,30);
        add(btn3);
        btn3.addActionListener(this);

        btn4=new JButton("Fiyat-artan");
        btn4.setBounds(350,55,100,30);
        add(btn4);
        btn4.addActionListener(this);

        btn5=new JButton("Fiyat-azalan");
        btn5.setBounds(455,55,100,30);
        add(btn5);
        btn5.addActionListener(this);

        btn6=new JButton("Id-artan");
        btn6.setBounds(350,90,100,30);
        add(btn6);
        btn6.addActionListener(this);

        btn7=new JButton("Id-azalan");
        btn7.setBounds(455,90,100,30);
        add(btn7);
        btn7.addActionListener(this);

        btn8=new JButton("İşlemci");
        btn8.setBounds(350,125,100,30);
        add(btn8);
        btn8.addActionListener(this);

        btn9=new JButton("Ekran kartı");
        btn9.setBounds(455,125,100,30);
        add(btn9);
        btn9.addActionListener(this);

        btn10=new JButton("Arama yap");
        btn10.setBounds(455,160,100,30);
        add(btn10);
        btn10.addActionListener(this);

        txt1=new JTextField("Ürün girin");
        txt1.setBounds(350,160,100,30);
        add(txt1);

        //textfield için focuslistener ekledik. bu sayede field üstüne tıklandığında içinde geçici
        //olarak bulunan değer otomatik olarak silinir. örn: "giriş yapın" değeri silinir.
        txt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt1.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt2=new JTextField("Id girin");
        txt2.setBounds(10,200,100,30);
        add(txt2);
        txt2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt2.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt3=new JTextField("Stok girin");
        txt3.setBounds(10,235,100,30);
        add(txt3);
        txt3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt3.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        btn11=new JButton("Güncelle");
        btn11.setBounds(115,200,100,30);
        add(btn11);
        btn11.addActionListener(this);

        btn12=new JButton("Ürünü sil");
        btn12.setBounds(115,235,100,30);
        add(btn12);
        btn12.addActionListener(this);

        txt4=new JTextField("Id girin");
        txt4.setBounds(250,200,100,30);
        add(txt4);
        txt4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt4.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt5=new JTextField("İsim girin");
        txt5.setBounds(250,235,100,30);
        add(txt5);
        txt5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt5.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt6=new JTextField("Fiyat girin");
        txt6.setBounds(250,270,100,30);
        add(txt6);
        txt6.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt6.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt7=new JTextField("Tür girin");
        txt7.setBounds(250,305,100,30);
        add(txt7);
        txt7.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt7.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        txt8=new JTextField("Stok girin");
        txt8.setBounds(250,340,100,30);
        add(txt8);
        txt8.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt8.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        btn13=new JButton("Ürün ekle");
        btn13.setBounds(355,340,100,30);
        add(btn13);
        btn13.addActionListener(this);


        //bağlantı kuruluyor, buttonclick eventinde belirlenen olay yapılıyor. örn: urunler tablosunu listele.
        //tablo için tablomodel oluşturuluyor, bu model frame üzerindeki tabloya atanıyor. jscrollpane
        //kullanılmazsa tablo içinde yukarı-aşağı scroll işlemi yapılamaz.
        //her işlem sonucunda (sıralama-ekleme-silme vb. tekrar model oluşturuluyor, bu sayede anında
        //güncel bir tablo gösteriliyor.
        try{
            String host = "jdbc:mysql://localhost:3306/stoktakip";
            String uName = "root";
            String uPass = "Osman.1533";
            Connection conn = DriverManager.getConnection(host,uName,uPass);
            PreparedStatement ps = conn.prepareStatement("Select * from urunler");
            ResultSet rs=ps.executeQuery();
            String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            tablo.setModel(tableModel);
            while(rs.next()){
                String id1 = rs.getString("id");
                String isim1 = rs.getString("isim");
                String fiyat1 = rs.getString("fiyat");
                String tur1 = rs.getString("tur");
                String stok1 = rs.getString("stok");
                String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                tableModel.addRow(data);
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hata oluştu."+e);
        }

        jsn1 = new JScrollPane(tablo);            // add table to scroll panel
        jsn1.setBounds(5, 10, 300, 150);
        setTitle("Yönetici Ekranı");
        setBounds(400, 100, 700, 600);
        jsn1.setVisible(true);
        panel1.add(jsn1);
        this.add(panel1);

        //giriş başarılıysa, mesaj yazdırılır.
        JOptionPane.showMessageDialog(null, "Yönetici girişi başarılı.");
    }

    //tıklama sonucu gerçekleşecek olaylar.
    public void actionPerformed(ActionEvent e) {

        //yapılan girişler String değişkenlere alınıyor.
        String giris1 = (txt1.getText());
        String urungiris=(txt2.getText());
        String stokgiris=(txt3.getText());
        String idgiris=(txt4.getText());
        String isimgiris=(txt5.getText());
        String fiyatgiris=(txt6.getText());
        String turgiris=(txt7.getText());
        String yenistokgiris=(txt8.getText());

        if (e.getSource().equals(btn1)) {
            dispose();
        }
        if (e.getSource().equals(btn2)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by stok asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn3)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by stok desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn4)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by fiyat asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn5)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by fiyat desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn6)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by id asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn7)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by id desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }
        if (e.getSource().equals(btn8)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where tur='islemci'");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn9)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where tur='ekran karti'");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn10)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where isim=?");
                ps.setString(1,giris1);
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        //update-delete işlemlerinin yapılabilmesi için, select işleminde kullanılan executequery() metodu
        //yerine executeupdate() metodu kullanılmalıdır.
        if (e.getSource().equals(btn11)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("update urunler set stok=? where id=?");
                ps.setString(1,stokgiris);
                ps.setString(2,urungiris);
                int rs=ps.executeUpdate();
            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }

            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }

        }

        if (e.getSource().equals(btn12)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("delete from urunler where id=?");
                ps.setString(1,urungiris);
                int rs=ps.executeUpdate();
            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Error in Employee Grid View..... "+es);
            }

            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }

        }

        if (e.getSource().equals(btn13)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("insert into urunler (id,isim,fiyat,tur,stok) values(?,?,?,?,?)");
                ps.setString(1,idgiris);
                ps.setString(2,isimgiris);
                ps.setString(3,fiyatgiris);
                ps.setString(4,turgiris);
                ps.setString(5,yenistokgiris);
                int rs=ps.executeUpdate();
            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Error in Employee Grid View..... "+es);
            }

            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }
        }
        }