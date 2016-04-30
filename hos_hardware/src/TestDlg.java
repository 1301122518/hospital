package com.synjones.angel;

import java.awt.*;   
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.sun.jna.win32.*;
import com.sun.jna.*;

public class TestDlg extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7495940408592595397L;
	
	private JPanel mainPanel;						//�����
	private Button[] button = new Button[6];		//������ϰ�ť
	private JPanel[] buttonPanel = new JPanel[4];	//�ĸ��������
	private JPanel[] firstPanel = new JPanel[9];	//��һ����������µľŸ��������
	private Button[][] b = new Button[4][3];		//��������µ�12����ť
	private Button b33 = new Button("����_���֤��");//���һ������������İ�ť
	//��һ����������ڵ�3����ǩ��3���༭��
	private JLabel lbPort;
	private JLabel lbMaxByte;
	private JLabel lbBaud;
	private JTextField port;
	private JTextField maxByte;
	private JTextField baud;

	private JTable table;		//��Ϣ�б�
	private Table_Model model = null;
	private JScrollPane s_pan = null;
	
	public TestDlg() {
		//���ÿ�ܳ�ʼ������
		this.setTitle("����֤��ȡ");
		this.setLocation(200, 50);
		
		/*��ʼ��������ʼ*/
		mainPanel = new JPanel();	//��ʼ�������
		//��ʼ������尴ť
		button[0] = new Button("��λSAM�����ã�");
		button[1] = new Button("���SAM״̬");
		button[2] = new Button("���SAM���к�");
		button[3] = new Button("ʹ�ýṹ�巵����Ϣ");
		button[4] = new Button("���������Ϣ");
		button[4].setPreferredSize(new Dimension(100,25));
		button[5] = new Button("�˳�");
		button[5].setPreferredSize(new Dimension(94, 25));
		//��ʼ���������
		for (int i = 0; i < 4; i++) {
			buttonPanel[i] = new JPanel();
		}
		//��ʼ���������
        for (int i = 0; i < 9; i++) {
        	firstPanel[i] = new JPanel();
        }
		//��ʼ����ť
		b[0][0] = new Button("�Զ�Ѱ�Ҷ�����");     
		b[0][1] = new Button("���ͨ���ֽ���");
		b[0][2] = new Button("����ͨ�Ų�����");
		b[0][2].setEnabled(false);		//��ť��ʼ������
		b[1][0] = new Button("����C�̸�Ŀ¼");
		b[1][1] = new Button("���ڵ�ǰĿ¼");
		b[1][2] = new Button("����ѡ��·��");
		b[2][0] = new Button("��ΪBmp��ʽ");
		b[2][1] = new Button("��ΪJpeg��ʽ");
		b[2][2] = new Button("��ΪBase64��ʽ");
		b[3][0] = new Button("tmp");
		b[3][1] = new Button("����");
		b[3][2] = new Button("���֤��");
		//��ʼ����ǩ
        lbPort = new JLabel("�˿ںţ�");
        lbMaxByte = new JLabel("<html>�������ͨ��<br>�ֽ���(24-255):</html>");
        lbMaxByte.setFont(new java.awt.Font("Dialog", 1, 9));
        lbBaud = new JLabel("�����ʣ�");
        //��ʼ���༭��
        port = new JTextField(6);
        port.setText("1");		//��ʼֵΪ1
        maxByte = new JTextField(6);
        maxByte.setText("80");	//��ʼֵΪ80
        baud = new JTextField(6);
        baud.setEnabled(false);	//��ʼ������
        /*��ʼ����������*/
        
		//��Ӱ�ť�����¼�
		for (int i = 0; i < 4; i++) {
        	for(int j=0; j<3; j++){
        		b[i][j].addActionListener(this);
        	}
        }
		b33.addActionListener(this);
		for (int i = 0; i < 6; i++){
			button[i].addActionListener(this);
		}
		
		//����ť��ӵ������
    	for ( int i = 0; i < 6; i++) {
    		mainPanel.add(button[i]);
    	}
		
		//���ø�����������
		buttonPanel[0].setBorder(BorderFactory.createTitledBorder("SAM���ú���"));
        buttonPanel[1].setBorder(BorderFactory.createTitledBorder("��Ƭ���·������"));
        buttonPanel[2].setBorder(BorderFactory.createTitledBorder("��Ƭ�����ʽ"));
        buttonPanel[3].setBorder(BorderFactory.createTitledBorder("��Ƭ�ļ�����ʽ"));
        
		//���ø���������С��������
        buttonPanel[0].setPreferredSize(new Dimension(260,120));
		buttonPanel[0].setLayout(new GridLayout(3, 3, 1, 1));
		buttonPanel[1].setPreferredSize(new Dimension(120,120));
		buttonPanel[1].setLayout(new GridLayout(3, 1, 1, 5));
		buttonPanel[2].setPreferredSize(new Dimension(120,120));
		buttonPanel[2].setLayout(new GridLayout(3, 1, 1, 5));
		buttonPanel[3].setPreferredSize(new Dimension(120,120));
		buttonPanel[3].setLayout(new GridLayout(4, 1, 1, 1));
        
        //�����Ӧ���ݵ��Ÿ��������
        firstPanel[0].add(lbPort);
        firstPanel[1].add(port);
        firstPanel[2].add(b[0][0]);
        firstPanel[3].add(lbMaxByte);
        firstPanel[4].add(maxByte);
        firstPanel[5].add(b[0][1]);
        firstPanel[6].add(lbBaud);
        firstPanel[7].add(baud);
        firstPanel[8].add(b[0][2]);
        
        //�����������ӵ���һ���������
        for (int i = 0; i < 9; i++) {
        	buttonPanel[0].add(firstPanel[i]);
        }
        
        //�����ఴť������Ӧ�������
        for (int i = 1; i < 4; i++) {
    		for (int j = 0; j < 3; j++) {
    			buttonPanel[i].add(b[i][j]);
    		}
    	}
    	buttonPanel[3].add(b33);
    	
		//�����������ӵ������
    	for (int i = 0; i < 4; i++) {
    		mainPanel.add(buttonPanel[i]);
    	}

    	/*��Ϣ�б����ÿ�ʼ*/
    	//��ʼ����Ϣ�б�
        model = new Table_Model(20);
        table = new JTable(model);
        table.setBackground(Color.white);
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(300);
        
    	s_pan = new JScrollPane(table);
    	s_pan.setPreferredSize(new Dimension(640, 300));
    	/*��Ϣ�б����ý���*/
    	
    	//����Ϣ�б���������
    	mainPanel.add(s_pan);
    	
    	//������������
        this.getContentPane().add(mainPanel);
		this.setResizable(false);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(660, 500);
    	this.setVisible(true);
	}
	
	//�˽ӿ�һ��Ҫ�̳�StdCallLibrary �����������!
	public interface SynIDCardAPI extends StdCallLibrary  {
		String path = TestDlg.class.getResource("/").getPath().substring(1).replace("/", "\\") + "SynIDCardAPI";
		SynIDCardAPI INSTANCE = (SynIDCardAPI)Native.loadLibrary(path, SynIDCardAPI.class);

		//SAM�˿ں���
		public int Syn_SetMaxRFByte(int iPort, char ucByte, int bIfOpen);
		public int Syn_GetCOMBaudEx(int iPort);
		public int Syn_SetCOMBaud(int iPort, int uiCurrBaud, int uiSetBaud);
		public int Syn_OpenPort(int iPort);
		public int Syn_ClosePort (int iPort);
		//SAM�ຯ��
		public int Syn_ResetSAM(int iPort, int iIfOpen);
		public int Syn_GetSAMStatus(int iPort, int	iIfOpen);
		public int Syn_GetSAMID(int iPort, char[] pucSAMID, int iIfOpen);
		//���֤���ຯ��
		public int Syn_StartFindIDCard(int iPort, char[] pucIIN, int iIfOpen);
		public int Syn_SelectIDCard(int iPort, char[] pucSN, int iIfOpen);
		public int Syn_ReadMsg(int iPort, int iIfOpen, IDCardData pINCardData);
		public int Syn_FindReader();
		//���ø��ӹ��ܺ���
		public int Syn_SetPhotoPath(int iOption, String cPhotopath);
		public int Syn_SetPhotoType(int iType);
		public int Syn_SetPhotoName(int iType);
		public int Syn_SetSexType( int iType );
		public int Syn_SetNationType(int iType);
		public int Syn_SetBornType(int iType);
		public int Syn_SetUserLifeBType(int iType);
		public int Syn_SetUserLifeEType(int iTyp, int iOption);	
	}
	
	//��ʾ��Ϣ�Զ����������һ��
	private void scrollEnd(){
		int rowCount = table.getRowCount();
		Rectangle rect = table.getCellRect(rowCount-1, 0, true);
		table.scrollRectToVisible(rect);
	}
    
	//�̳���ActionListener
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        if (source == button[0]) {
        	String sMsg;        	
        	int iPort = Integer.parseInt(port.getText());
        	int nRet = SynIDCardAPI.INSTANCE.Syn_OpenPort(iPort);
        	if (nRet == 0)
        	{
        		nRet = SynIDCardAPI.INSTANCE.Syn_ResetSAM(iPort, 0);
        		if (nRet == 0)
        		{
        			sMsg = "��λSAMģ��ɹ�";
        		}
        		else
        		{
        			sMsg = "��λSAMģ��ʧ��";
        		}
        	}
        	else
        	{
        		sMsg = "�򿪶˿ڴ���";
        	}
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == button[1]) {
        	String sMsg;
        	int iPort = Integer.parseInt(port.getText());
        	int nRet = SynIDCardAPI.INSTANCE.Syn_OpenPort(iPort);
        	if (nRet == 0)
        	{
        		nRet = SynIDCardAPI.INSTANCE.Syn_GetSAMStatus(iPort, 0);
        		if (nRet == 0)
        		{
        			sMsg = "SAMģ��״̬����";
        		}
        		else
        		{
        			sMsg = "���SAMģ��״̬ʧ��";
        		}
        	}
        	else
        	{
        		sMsg = "�򿪶˿ڴ���";
        	}
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == button[2]) {
        	String sMsg;
        	int iPort = Integer.parseInt(port.getText());
        	int nRet = SynIDCardAPI.INSTANCE.Syn_OpenPort(iPort);
        	if (nRet == 0)
        	{
            	char[] strSAMID = new char[8];
        		nRet = SynIDCardAPI.INSTANCE.Syn_GetSAMID(iPort, strSAMID, 0);
        		if (nRet == 0)
        		{
        			long[] iSAMID = new long[3];
        			iSAMID[0] = (long)strSAMID[3] * 65536 + (long)strSAMID[2];
        			iSAMID[1] = (long)strSAMID[5] * 65536 + (long)strSAMID[4];
        			iSAMID[2] = (long)strSAMID[7] * 65536 + (long)strSAMID[6];
        			sMsg = String.format("��16�ֽڻ��SAMģ��ID�ɹ�,SAMģ��IDΪ: %d-%d-%d-%d-%d", (int)strSAMID[0], (int)strSAMID[1], iSAMID[0], iSAMID[1], iSAMID[2]);
        		}
        		else
        		{
        			sMsg = "��ȡSAM ID�Ŵ���";
        		}
        	}
        	else
        	{
        		sMsg = "�򿪶˿ڴ���";
        	}
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == button[3]) {
        	String sMsg;
        	SynIDCardAPI.INSTANCE.Syn_SetSexType(1);
        	SynIDCardAPI.INSTANCE.Syn_SetNationType(1);
        	SynIDCardAPI.INSTANCE.Syn_SetBornType(2);
        	SynIDCardAPI.INSTANCE.Syn_SetUserLifeBType(3);
        	SynIDCardAPI.INSTANCE.Syn_SetUserLifeEType(4,1);

        	int iPort = Integer.parseInt(port.getText());
        	int nRet = SynIDCardAPI.INSTANCE.Syn_OpenPort(iPort);
        	if (nRet == 0)
        	{
        		if (SynIDCardAPI.INSTANCE.Syn_SetMaxRFByte(iPort, (char)80, 0) == 0)
        		{
        			char[] pucIIN = new char[8];
        			char[] pucSN = new char[8];
                	IDCardData idcardData = new IDCardData();
        			nRet = SynIDCardAPI.INSTANCE.Syn_StartFindIDCard(iPort, pucIIN, 0);
        			nRet = SynIDCardAPI.INSTANCE.Syn_SelectIDCard(iPort, pucSN, 0);
        			if (SynIDCardAPI.INSTANCE.Syn_ReadMsg(iPort, 0, idcardData) == 0)
        			{
        				sMsg= "��ȡ���֤��Ϣ�ɹ�!";
        				model.addRow(sMsg);
        				table.updateUI();
        				try{
        					String strTemp = new String(idcardData.Name, "GBK");
        					sMsg = String.format("����:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.Sex, "GBK");
            				sMsg = String.format("�Ա�:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.Nation, "GBK");
            				sMsg = String.format("����:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.Born, "GBK");
            				sMsg = String.format("����:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.Address, "GBK");
            				sMsg = String.format("סַ:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.IDCardNo, "GBK");
            				sMsg = String.format("���֤��:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.GrantDept, "GBK");
            				sMsg = String.format("��֤����:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.UserLifeBegin, "GBK");
            				sMsg = String.format("��Ч�ڿ�ʼ:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.UserLifeEnd, "GBK");
            				sMsg = String.format("��Ч�ڽ���:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
            				strTemp = new String(idcardData.PhotoFileName, "GBK");
            				sMsg = String.format("��Ƭ:%s", strTemp);
            				model.addRow(sMsg);
            				table.updateUI();
        				}catch (UnsupportedEncodingException une) {
        					une.printStackTrace();
        				}
        			}
        			else
        			{
        				sMsg = "��ȡ���֤��Ϣ����!";
        				model.addRow(sMsg);
        				table.updateUI();
        			}
        		}
        	}
        	else
        	{
        		sMsg = "�򿪶˿ڴ���";
        		model.addRow(sMsg);
        		table.updateUI();
        	}
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	scrollEnd();
        }
        else if (source == button[4]) {
        	model.removeRows(0, model.getRowCount());
            table.updateUI();
        }
        else if (source == button[5]) {
        	System.exit(0);
        }
        else if(source == b[0][0]) {
            int nRet;
        	String sMsg, sMsg2;
        	nRet = SynIDCardAPI.INSTANCE.Syn_FindReader();
        	if (nRet == 0)
        	{
        		sMsg = "û���Ҵ������";
        	}
        	else
        	{
        		//Toolkit.getDefaultToolkit().beep();
        		baud.setEnabled(true);
    			b[0][2].setEnabled(true);
        		if (nRet >1000)
        		{
        			sMsg = String.format("������������USB�˿� %d", nRet); 
        		}
        		else
        		{
        			try{
        				Thread.sleep(200);
        			}catch (InterruptedException exc) {
        				System.out.println("error");
        			}
        			int uiCurrBaud = SynIDCardAPI.INSTANCE.Syn_GetCOMBaudEx(nRet);
        			sMsg2 = String.format("%d", uiCurrBaud);
        			baud.setText(sMsg2);
        			sMsg = String.format("�����������ڴ��� %d,��ǰSAM������Ϊ %d", nRet, uiCurrBaud); 
        		}
        		sMsg2 = String.format("%d", nRet);
        		port.setText(sMsg2);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[0][1]) {
        	String sMsg,sMsg2;
        	sMsg2 = port.getText();
        	int iPort = Integer.parseInt(sMsg2);
        	sMsg2 = maxByte.getText();
        	int iByte = Integer.parseInt(sMsg2);
        	char iMaxByte = (char)iByte;
        	int nRet = SynIDCardAPI.INSTANCE.Syn_OpenPort(iPort);
        	if (nRet == 0)
        	{
        		if (SynIDCardAPI.INSTANCE.Syn_GetSAMStatus(iPort, 0) == 0)
        		{
        			if(SynIDCardAPI.INSTANCE.Syn_SetMaxRFByte(iPort, iMaxByte, 0) == 0)
        			{
        				sMsg = String.format("�������ͨѶ�ֽ����ɹ�,���ͨѶ�ֽ���Ϊ %d", iByte);
        			}
        			else
        			{
        				sMsg = "�������ͨѶ�ֽ�������!";
        			}
        		}
        		else
        		{
        			sMsg = String.format("�˿� %d ��û�����Ӷ�����!", iPort);
        		}
        	}
        	else
        	{
        		sMsg = "�򿪶˿ڴ���";
        	}
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[0][2]) {
        	String sMsg,sMsg2;
        	sMsg2 = port.getText();
        	int iPort = Integer.parseInt(sMsg2);
        	int iCurrBaud = SynIDCardAPI.INSTANCE.Syn_GetCOMBaudEx(iPort);
        	if (iCurrBaud == 0 )
        	{
        		sMsg="��õ�ǰ������������ʧ��";
        		model.addRow(sMsg);
            	table.updateUI();
        		return;
        	}
        	sMsg2 = baud.getText();
        	int iSetBaud = Integer.parseInt(sMsg2);
        	SynIDCardAPI.INSTANCE.Syn_ClosePort(iPort);
        	if(SynIDCardAPI.INSTANCE.Syn_SetCOMBaud(iPort, iCurrBaud, iSetBaud) == 0)
        	{
        		sMsg = String.format("���ö����������ʳɹ�,��ǰ������Ϊ %d ", iSetBaud);
        	}
        	else
        	{
        		sMsg = "���ö�����������ʧ��";
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[1][0]) {
        	String strTmp = new String();
        	int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoPath(0, strTmp);
        	String strInfo = new String();
        	strInfo = String.format("��Ƭ���·������Ϊ C:,nRet = %d", nRet);
        	model.addRow(strInfo);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[1][1]) {
        	String strTmp = new String();
        	int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoPath(1, strTmp);
        	String strInfo = new String();
        	if (nRet == 0)
        		strInfo = String.format("��Ƭ���·������Ϊ��ǰ·��,nRet = %d", nRet);
        	else
        		strInfo = String.format("��Ƭ���·�����ô���,nRet = %d", nRet);
        	model.addRow(strInfo);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[1][2]){
        	String strInfo = new String();
        	JFileChooser fileChooser = new JFileChooser(".");
        	fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    		fileChooser.setDialogTitle("���ļ���");
    		int ret = fileChooser.showOpenDialog(null);
    		if (ret == JFileChooser.APPROVE_OPTION) {
    			//�ļ���·��
    			String strPath = fileChooser.getSelectedFile().getAbsolutePath();
    			int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoPath(0, strPath);
            	strInfo = String.format("��Ƭ���·������Ϊ %s,nRet = %d", strPath, nRet);
    		}
    		else {
    			strInfo = "ѡȡ·��ʧ�ܣ�";
    		}
        	model.addRow(strInfo);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[2][0]) {
        	String sMsg = new String();
        	int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoType(0);
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ʽ����Ϊ Bmp,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[2][1]) {
        	String sMsg = new String();
        	int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoType(1);
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ʽ����Ϊ Jpeg,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[2][2]) {
        	String sMsg = new String();
        	int nRet = SynIDCardAPI.INSTANCE.Syn_SetPhotoType(2);
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ʽ����Ϊ Base64,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[3][0]) {
        	int nRet =  SynIDCardAPI.INSTANCE.Syn_SetPhotoName(0);
        	String sMsg;
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����Ϊ tmp,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[3][1]) {
        	int nRet =  SynIDCardAPI.INSTANCE.Syn_SetPhotoName(1);
        	String sMsg;
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����Ϊ ����,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b[3][2]) {
        	int nRet =  SynIDCardAPI.INSTANCE.Syn_SetPhotoName(2);
        	String sMsg;
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����Ϊ ���֤��,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }
        else if (source == b33) {
        	int nRet =  SynIDCardAPI.INSTANCE.Syn_SetPhotoName(3);
        	String sMsg;
        	if (nRet == 0)
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����Ϊ ����_���֤��,nRet = %d", nRet);
        	}
        	else
        	{
        		sMsg = String.format("��Ƭ�����ļ�����ʽ����ʧ��,nRet = %d", nRet);
        	}
        	model.addRow(sMsg);
        	table.updateUI();
        	scrollEnd();
        }   
    }     
  
    public static void main(String[] args) {   
        new TestDlg();
    }   
}

class Table_Model extends AbstractTableModel {
    private static final long serialVersionUID = -7495940408592595395L;
    private Vector content = null;
    private String[] title_name = {"����ʱ��", "��Ϣ"};
    
    public Table_Model(int count) {
        content = new Vector(count);
    }
    
    //�������
    public void addRow(String strInfo) {
        Vector v = new Vector(2);
        Calendar now = Calendar.getInstance();
        String time = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH)
        			  +" "+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
        v.add(0, time);
        v.add(1, strInfo);
        content.add(v);
    }
    
    //ɾ������
    public void removeRows(int row, int count) {
        for (int i = 0; i < count; i++) {
            if (content.size() > row) {
                content.remove(row);
            }
        }
    }

    //���º���Ϊ�̳���AbstractTableModel
    public String getColumnName(int col) {
        return title_name[col];
    }
    public int getColumnCount() {
        return title_name.length;
    }
    public int getRowCount() {
        return content.size();
    }
    public Object getValueAt(int row, int col) {
        return ((Vector) content.get(row)).get(col);
    }
}


