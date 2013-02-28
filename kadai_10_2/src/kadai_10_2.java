//test1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.border.*;
import java.io.*;
public class kadai_10_2 extends JFrame{
static int k_lavel = 1;
static int n_lavel = 1;
static int p_lavel = 1;
static JLabel l2;	/*ラベルへの文字出力用*/
/*コンストラクタ*/
kadai_10_2(){
JFrame frame = new JFrame("Java第10回課題");
//setBounds(表示位置ｘ、表示位置ｙ、幅、高さ）
frame.setBounds(350, 100, 600, 528);
//ｘによるウィンドウの終了
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//コマンド配置のパネルp1=========================================================
JPanel p1 = new JPanel();
p1.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.black));
p1.setPreferredSize(new Dimension(0,100));	/*xは反映されてない。幅は自動だと思われる。*/
p1.setLayout(new GridLayout(2,3));
//ボタンをパネルp1に追加;---------------------------------------------------------
ArrayList<JButton> button = new ArrayList<JButton>();	/*コレクションの使用*/
ImageIcon neko = new ImageIcon(getClass().getResource("neko.png"));
ImageIcon kama = new ImageIcon(getClass().getResource("kama.png"));
ImageIcon pu = new ImageIcon(getClass().getResource("pu.png"));
button.add(new JButton("マタタビ"));
button.add(new JButton("バッタ"));
button.add(new JButton("イネ科の草"));
button.add(new JButton("ネコ ",neko));
button.add(new JButton("カマキリ ",kama));
button.add(new JButton("プレーリードッグ",pu));
for(JButton x:button){
p1.add(x);
}
JButton b1 = button.get(0);
JButton b2 = button.get(1);
JButton b3 = button.get(2);
JButton b4 = button.get(3);
JButton b5 = button.get(4);
JButton b6 = button.get(5);
b1.addActionListener(new levelUp(1));
b2.addActionListener(new levelUp(2));
b3.addActionListener(new levelUp(3));
b4.addActionListener(new status(1));
b5.addActionListener(new status(2));
b6.addActionListener(new status(3));
frame.add(p1, BorderLayout.SOUTH);
//========================================================================
//画像用のラベルl1===========================================================
JLabel l1 = new JLabel();
l1.setPreferredSize(new Dimension(600,365));
ImageIcon backGround = new ImageIcon(getClass().getResource("background.png"));
l1.setIcon(backGround);
frame.add(l1,BorderLayout.NORTH);

//文字用のパネルp2-----------------------------------------------------------
JPanel p2 = new JPanel();
p2.setPreferredSize(new Dimension(500,100));
p2.setBackground(Color.BLACK);
p2.setBorder(new LineBorder(Color.white, 4, false));
l1.setLayout(new BorderLayout());	
//文字の表示用のラベルl2------------------------------------------------------
l2 = new JLabel();
l2.setPreferredSize(new Dimension(400,70));
l2.setForeground(Color.white);	/*文字の色*/
p2.setLayout(new BorderLayout());	/*p2に貼り付け*/
p2.add(l2,BorderLayout.CENTER);
l1.add(p2,BorderLayout.SOUTH);	/*p2をl1に貼り付け*/

//キャラの貼り付けパネルp3-------------------------------------------------------
JPanel p3 = new JPanel();
p3.setPreferredSize(new Dimension(500,350));
p3.setOpaque(false);	/*パネル背景の透明化*/
p3.setLayout(new BorderLayout());
//キャラの貼り付けラベルl3--------------------------------------------------------
JLabel l3 = new JLabel();
JLabel l4 = new JLabel();
JLabel l5 = new JLabel();
ImageIcon kamakiri1 = new ImageIcon(getClass().getResource("kamakiri1.png"));
ImageIcon neko1 = new ImageIcon(getClass().getResource("neko1.png"));
ImageIcon pureri1 = new ImageIcon(getClass().getResource("pureri1.png"));
l3.setIcon(kamakiri1);
l4.setIcon(neko1);
l5.setIcon(pureri1);
p3.add(l3,BorderLayout.CENTER);	/*p3に貼り付け*/
p3.add(l4,BorderLayout.WEST);
p3.add(l5,BorderLayout.EAST);
l1.add(p3,BorderLayout.NORTH);	/*p3をl1に貼り付け*/

//========================================================================
//バーの作成================================================================
JMenuBar menuBar = new JMenuBar();
frame.setJMenuBar(menuBar);
//[メニュー]
JMenu menu = new JMenu("メニュー");
menuBar.add(menu);
//[メニュー]-[セーブ]
JMenuItem save = new JMenuItem("セーブ");
save.addActionListener(new MENU());
menu.add(save);
//[----]
menu.addSeparator();
//[メニュー]-[ロード]
JMenuItem load = new JMenuItem("ロード");
load.addActionListener(new MENU());
menu.add(load);
//[----]
menu.addSeparator();
//[メニュー]-[リセット]
JMenuItem menuReset = new JMenuItem("最初からはじめる");
menuReset.addActionListener(new MENU());
menu.add(menuReset);
//[----]
menu.addSeparator();
// [メニュー]-[終了]
JMenuItem menuExit = new JMenuItem("終了");
menuExit.addActionListener(new MENU());
menu.add(menuExit);
//===========================================================================
frame.setVisible(true);	
AudioClip start = Applet.newAudioClip(getClass().getResource("start.wav"));
start.loop();

}


//レベルアップ＿アクション===========================================================
/*staticなしだとkadai_10_2のインスタンスからしか生成できない*/
static class levelUp implements ActionListener{
int num;
AudioClip UP;
levelUp(int num){
this.num = num;
}
public void actionPerformed(ActionEvent e){
UP = Applet.newAudioClip(getClass().getResource("UP.wav"));
UP.play();
if(num==1){
n_lavel++;
l2.setText("ネコのレベルが上がった");
}
else if(num==2){
k_lavel++;
l2.setText("カマキリのレベルが上がった");
}
else if(num==3){
p_lavel++;
l2.setText("プレーリードッグのレベルが上がった");
}

}
}//============================================================================
//ステータス＿アクション===============================================================
static class status implements ActionListener{
int num;
status(int num){
this.num = num;
}
public void actionPerformed(ActionEvent e){
AudioClip click = Applet.newAudioClip(getClass().getResource("pi.wav"));
click.play();
if(num==1) l2.setText("ネコのレベル:"+n_lavel);
else if(num==2) l2.setText("カマキリのレベル:"+k_lavel);
else if(num==3) l2.setText("プレーリードッグのレベル:"+p_lavel);
}
}//=============================================================================
//メニュー＿アクション=================================================================
static class MENU implements ActionListener{
public void actionPerformed(ActionEvent e) {
String reset = "最初からはじめる";
String exit = "終了";
String save = "セーブ";
String load = "ロード";
//リセット-------------------------------------------------------------------
if(reset.equals(e.getActionCommand())) {
AudioClip click = Applet.newAudioClip(getClass().getResource("pi.wav"));
click.play();
n_lavel = k_lavel = p_lavel =1;
l2.setText("初期化されました");
}
//終了---------------------------------------------------------------------
else if(exit.equals(e.getActionCommand()))
System.exit(0);
//ロード---------------------------------------------------------------------
else if(load.equals(e.getActionCommand())){
l2.setText("ロードしました");
AudioClip LOAD = Applet.newAudioClip(getClass().getResource("load.wav"));
LOAD.play();
try {
BufferedReader br
= new BufferedReader(new FileReader("save.txt"));
//ファイルの場所注意。デフォルトパッケージ内だとエラー。Testファイル内。
//プロジェクトを右クリック、新規からtxt作成でいい。
String str;
while (true) {
str = br.readLine();
if (str == null) break;
StringTokenizer st = new StringTokenizer(str, ",");
n_lavel = Integer.parseInt(st.nextToken());
k_lavel = Integer.parseInt(st.nextToken());
p_lavel = Integer.parseInt(st.nextToken());
}
br.close();
} catch (IOException er) {
er.printStackTrace();
}
}
//セーブ-----------------------------------------------------------------
else if(save.equals(e.getActionCommand())){
l2.setText("セーブしました");
AudioClip SAVE = Applet.newAudioClip(getClass().getResource("save.wav"));
SAVE.play();
try{
File file = new File("save.txt");
FileWriter filewriter = new FileWriter(file);
filewriter.write(n_lavel+","+k_lavel+","+p_lavel);
filewriter.close();
}catch(IOException er){
System.out.println(er);
}
}
}
}//===============================================================================

public static void main(String args[]) {
new kadai_10_2();
}
}