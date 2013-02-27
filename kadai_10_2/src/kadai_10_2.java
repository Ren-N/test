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
	static JLabel l2;		/*���x���ւ̕����o�͗p*/
	/*�R���X�g���N�^*/
	kadai_10_2(){
		JFrame frame = new JFrame("Java��10��ۑ�");
		//setBounds(�\���ʒu���A�\���ʒu���A���A�����j
		frame.setBounds(350, 100, 600, 523);
		//���ɂ��E�B���h�E�̏I��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�R�}���h�z�u�̃p�l��p1=========================================================
		JPanel p1 = new JPanel();
		p1.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.black));
		p1.setPreferredSize(new Dimension(0,100));	/*x�͔��f����ĂȂ��B���͎������Ǝv����B*/
		p1.setLayout(new GridLayout(2,3));
		//�{�^�����p�l��p1�ɒǉ�;---------------------------------------------------------
		ArrayList<JButton> button = new ArrayList<JButton>();	/*�R���N�V�����̎g�p*/
		ImageIcon neko = new ImageIcon(getClass().getResource("neko.png"));
		ImageIcon kama = new ImageIcon(getClass().getResource("kama.png"));
		ImageIcon pu = new ImageIcon(getClass().getResource("pu.png"));
		button.add(new JButton("�}�^�^�r"));
		button.add(new JButton("�o�b�^"));
		button.add(new JButton("�C�l�Ȃ̑�"));
		button.add(new JButton("�l�R                 ",neko));
		button.add(new JButton("�J�}�L��           ",kama));
		button.add(new JButton("�v���[���[�h�b�O",pu));
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
		//�摜�p�̃��x��l1===========================================================
		JLabel l1 = new JLabel();
		l1.setPreferredSize(new Dimension(600,365));
		ImageIcon backGround = new ImageIcon(getClass().getResource("background.png"));
		l1.setIcon(backGround);
		frame.add(l1,BorderLayout.NORTH);
		
		//�����p�̃p�l��p2-----------------------------------------------------------
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(500,100));
		p2.setBackground(Color.BLACK);
		p2.setBorder(new LineBorder(Color.white, 4, false));
		l1.setLayout(new BorderLayout());			
		//�����̕\���p�̃��x��l2------------------------------------------------------
		l2 = new JLabel();
		l2.setPreferredSize(new Dimension(400,70));
		l2.setForeground(Color.white);				/*�����̐F*/
		p2.setLayout(new BorderLayout());			/*p2�ɓ\��t��*/
		p2.add(l2,BorderLayout.CENTER);
		l1.add(p2,BorderLayout.SOUTH);				/*p2��l1�ɓ\��t��*/
		
		//�L�����̓\��t���p�l��p3-------------------------------------------------------
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(500,350));
		p3.setOpaque(false);			/*�p�l���w�i�̓�����*/
		p3.setLayout(new BorderLayout());
		//�L�����̓\��t�����x��l3--------------------------------------------------------
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		ImageIcon kamakiri1 = new ImageIcon(getClass().getResource("kamakiri1.png"));
		ImageIcon neko1 = new ImageIcon(getClass().getResource("neko1.png"));
		ImageIcon pureri1 = new ImageIcon(getClass().getResource("pureri1.png"));
		l3.setIcon(kamakiri1);
		l4.setIcon(neko1);
		l5.setIcon(pureri1);
		p3.add(l3,BorderLayout.CENTER);				/*p3�ɓ\��t��*/
		p3.add(l4,BorderLayout.WEST);
		p3.add(l5,BorderLayout.EAST);
		l1.add(p3,BorderLayout.NORTH);				/*p3��l1�ɓ\��t��*/
		
		//========================================================================
		//�o�[�̍쐬================================================================
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		//[���j���[]
		JMenu menu = new JMenu("���j���[");
		menuBar.add(menu);
		//[���j���[]-[�Z�[�u]
		JMenuItem save = new JMenuItem("�Z�[�u");
		save.addActionListener(new MENU());
		menu.add(save);
		//[----]
		menu.addSeparator();
		//[���j���[]-[���[�h]
		JMenuItem load = new JMenuItem("���[�h");
		load.addActionListener(new MENU());
		menu.add(load);
		//[----]
		menu.addSeparator();
		//[���j���[]-[���Z�b�g]
		JMenuItem menuReset = new JMenuItem("���Z�b�g");
		menuReset.addActionListener(new MENU());
		menu.add(menuReset);
		//[----]
		menu.addSeparator();
		// [���j���[]-[�I��]
		JMenuItem menuExit = new JMenuItem("�I��");
		menuExit.addActionListener(new MENU());
		menu.add(menuExit);
		//===========================================================================
		frame.setVisible(true);	
		AudioClip start = Applet.newAudioClip(getClass().getResource("start.wav"));
		start.loop();
		
}
	
	
	//���x���A�b�v�Q�A�N�V����===========================================================
	/*static�Ȃ�����kadai_10_2�̃C���X�^���X���炵�������ł��Ȃ�*/
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
				l2.setText("�l�R�̃��x�����オ����");
			}
			else if(num==2){
				k_lavel++;
				l2.setText("�J�}�L���̃��x�����オ����");
			}
			else if(num==3){
				p_lavel++;
				l2.setText("�v���[���[�h�b�O�̃��x�����オ����");
			}
			
		}
	}//============================================================================
	//�X�e�[�^�X�Q�A�N�V����===============================================================
	static class status implements ActionListener{
		int num;
		status(int num){
			this.num = num;
		}
		public void actionPerformed(ActionEvent e){
			AudioClip click = Applet.newAudioClip(getClass().getResource("pi.wav"));
			click.play();
			if(num==1) l2.setText("�l�R�̃��x��:"+n_lavel);
			else if(num==2) l2.setText("�J�}�L���̃��x��:"+k_lavel);
			else if(num==3) l2.setText("�v���[���[�h�b�O�̃��x��:"+p_lavel);
		}
	}//=============================================================================
	//���j���[�Q�A�N�V����=================================================================
	static class MENU implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String reset = "���Z�b�g";
			String exit = "�I��";
			String save = "�Z�[�u";
			String load = "���[�h";
			//���Z�b�g-------------------------------------------------------------------
			if(reset.equals(e.getActionCommand())) {
				AudioClip click = Applet.newAudioClip(getClass().getResource("pi.wav"));
				click.play();
				n_lavel = k_lavel = p_lavel =1;
				l2.setText("����������܂���");
			}
			//�I��---------------------------------------------------------------------
			else if(exit.equals(e.getActionCommand()))
				System.exit(0);
			//���[�h---------------------------------------------------------------------
			else if(load.equals(e.getActionCommand())){
				l2.setText("���[�h���܂���");
				AudioClip LOAD = Applet.newAudioClip(getClass().getResource("load.wav"));
				LOAD.play();
				try {
					BufferedReader br 
					= new BufferedReader(new FileReader("save.txt"));
					//�t�@�C���̏ꏊ���ӁB�f�t�H���g�p�b�P�[�W�����ƃG���[�BTest�t�@�C�����B
					//�v���W�F�N�g���E�N���b�N�A�V�K����txt�쐬�ł����B
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
			//�Z�[�u-----------------------------------------------------------------
			else if(save.equals(e.getActionCommand())){
				l2.setText("�Z�[�u���܂���");
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