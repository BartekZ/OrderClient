package pl.proacem.frame.component;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;
import pl.proacem.task.DeleteItemThread;
import pl.proacem.task.ThreadCompleteListener;

public class ItemDeleteButtonAction<T extends ModelInterface> implements ActionListener {
	private JTable table;
	private List<T> list;
	private ServiceInterface<T> service;
	private Frame frame;

	public ItemDeleteButtonAction(JTable atable, List<T> alist,
			ServiceInterface<T> aservice, Frame aframe) {
		this.table = atable;
		this.list = alist;
		this.service = aservice;
		this.frame = aframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (table.getSelectionModel().isSelectionEmpty() == true) {
			return;
		}
		T chosenItem = list.get(table.convertRowIndexToModel(table
				.getSelectedRow()));
		int n = JOptionPane.showConfirmDialog(frame,
				"Are you sure you want delete " + chosenItem + " ?", "",
				JOptionPane.YES_NO_OPTION);
		if (n == 0) {
			DeleteItemThread<T> deleteItemThread = new DeleteItemThread<T>(
					list, service, chosenItem);
			deleteItemThread.addListener(new ThreadCompleteListener() {

				@Override
				public void notifyOfThreadComplete(Thread thread) {
					table.getSelectionModel().clearSelection();
					table.updateUI();

				}
			});
			deleteItemThread.start();

		}

	}
}
