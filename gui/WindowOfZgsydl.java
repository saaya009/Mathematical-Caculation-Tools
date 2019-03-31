/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfZgsydl.java   
 * @Package gui   
 * @Description: 中国剩余定理求解图形类  
 * @author: JinZhiyun    
 * @date:   2019年3月16日 下午12:40:12   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * 注意：本内容由超级酷乐酱开发(wechat:Jzy_bb_1998)
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import someTest.Test;
import xxaqsxjc.method0.Zgsydl;

/**   
 * @ClassName:  WindowOfZgsydl   
 * @Description: 中国剩余定理求解图形类 
 * @author: JinZhiyun
 * @date:   2019年3月16日 下午12:40:12   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * 注意：本内容由超级酷乐酱开发(wechat:Jzy_bb_1998)
 */
public class WindowOfZgsydl {
	/**   
	 * @Title: GUIZgsydl   
	 * @Description: 设置中国剩余定理求解图形模块  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIZgsydl(JFrame frm) {
		JLabel j11 = new JLabel("11、中国剩余定理求解，方程组：x同余b 模 m，输入方程个数n，以及每个方程的系数，返回解x=?+?*q(q为整数)");
		j11.setBounds(50, 360, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("进入");
		btn.setBounds(710, 360, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // 按钮响应事件
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 800, 150); // 设置窗口初始位置和大小
				frmHidden.setTitle("中国剩余定理求解，方程组：x同余b 模 m，输入方程个数n，以及每个方程的系数，返回解x=?+?*q(q为整数)"); // 设置标题
				frmHidden.setLayout(null); // 如过不设置为null默认，按钮会充满整个内容框，挡住背景颜色

				GUIZgsydlHidden(frmHidden);

				frmHidden.setVisible(true); // 显示窗口
			}
		});

	}
	
	/**   
	 * @Title: GUIZgsydlHidden   
	 * @Description: 点击进入后的中国剩余定理求解图形模块   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIZgsydlHidden(JFrame frm) {
		JLabel j12 = new JLabel("请先输入方程个数n：");
		j12.setBounds(50, 30, 150, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// 创建文本行组件
		jtf1.setBounds(180, 30, 200, 25); // 左边距，上边距，长，宽
		frm.add(jtf1);

		JButton btn = new JButton("确定");
		btn.setBounds(390, 30, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // “确定”按钮响应事件
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText())) { // 方程个数的合法性检验
					if (new BigInteger(jtf1.getText()).compareTo(BigInteger.valueOf(25)) == -1) { // 限定方程个数小于等于25
						int num = Integer.parseInt(jtf1.getText());

						frm.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 800, 60 + num * 30 + 150);

						JLabel j13 = new JLabel("请输入方程x同余b[i] 模 m[i]的系数");
						j13.setBounds(50, 60, 200, 25);
						frm.add(j13);

						int yBase = 90; // 竖直方向的初始位置值

						JLabel[] j14 = new JLabel[num]; // b系数框
						JTextField[] jtf3 = new JTextField[num];

						JLabel[] j15 = new JLabel[num]; // m系数框
						JTextField[] jtf4 = new JTextField[num];

						for (int i = 0; i < num; i++) {
							j14[i] = new JLabel("第" + (i + 1) + "个方程系数： b[" + i + "]=");
							j14[i].setBounds(50, yBase + i * 30, 150, 25);
							frm.add(j14[i]);

							jtf3[i] = new JTextField();
							jtf3[i].setBounds(200, yBase + i * 30, 150, 25);
							frm.add(jtf3[i]);

							j15[i] = new JLabel("m[" + i + "]=");
							j15[i].setBounds(380, yBase + i * 30, 150, 25);
							frm.add(j15[i]);

							jtf4[i] = new JTextField();
							jtf4[i].setBounds(430, yBase + i * 30, 150, 25);
							frm.add(jtf4[i]);

						}

						JButton btnCacul = new JButton("计算");
						btnCacul.setBounds(50, yBase + num * 30, 80, 25);
						frm.add(btnCacul);

						JLabel j16 = new JLabel("该同余方程组的解为：x=");
						j16.setBounds(150, yBase + num * 30, 150, 25);
						frm.add(j16);
						JTextField jtf5 = new JTextField(); // 创建文本行组件
						jtf5.setBounds(300, yBase + num * 30, 450, 25); // 左边距，上边距，长，宽
						jtf5.setEditable(false);
						frm.add(jtf5);

						JLabel j17 = new JLabel("若要改变方程个数，请退出后重新进入！");
						j17.setBounds(50, yBase + num * 30 + 30, 250, 25);
						j17.setForeground(Color.red);
						frm.add(j17);

						btnCacul.addActionListener(new ActionListener() { // 按钮响应事件
							@Override
							public void actionPerformed(ActionEvent e) {
								BigInteger[] b = new BigInteger[num];
								BigInteger[] m = new BigInteger[num];
								for (int i = 0; i < num; i++) {
									b[i] = new BigInteger(jtf3[i].getText());
									m[i] = new BigInteger(jtf4[i].getText());
								}

								Zgsydl zgsydl = new Zgsydl();
								BigInteger[] x = zgsydl.zgsydl_solve(b, m);

								jtf5.setText(x[0] + "+" + x[1] + "*q(q为整数)");

							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "方程个数应小于等于25！");
					}
				}
			}
		});

	}
}
