package pl.proacem.frame.component;

import javax.swing.JTable;

import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.model.MainOrder;
import pl.proacem.model.ModelInterface;
import pl.proacem.model.SingleOrder;
import pl.proacem.service.RESTClient.ServiceInterface;
import pl.proacem.service.RESTClient.SingleOrderService;
import pl.proacem.task.PopulateItemListThread;
import pl.proacem.task.PopulateSingleOrdeListThread;
import pl.proacem.task.ThreadCompleteListener;

public class PopulateList<T extends ModelInterface> {
	private JTable table;
	private ObservableList<T> list;
	private ServiceInterface<T> service;
	private LoadingAnimation loading = null;
	private MainOrder mainorder;
	
	
	public PopulateList(JTable atable, ObservableList<T> alist, ServiceInterface<T> aservice) {
		this.table = atable;
		this.list = alist;
		this.service = aservice;
		init();
	}
	
	public PopulateList(JTable atable, ObservableList<T> alist, ServiceInterface<T> aservice, MainOrder amainorder) {
		this.table = atable;
		this.list = alist;
		this.service = aservice;
		this.mainorder= amainorder;
		init2();
	}


	private void init(){
		PopulateItemListThread<T> populateItemListThread = new PopulateItemListThread<T>(list, service);
		populateItemListThread.addListener(new ThreadCompleteListener() {
			
			@Override
			public void notifyOfThreadComplete(Thread thread) {
				
				
				table.getSelectionModel().clearSelection();
				if (loading != null){
					loading.setVisible(false);
				}
				
			}
		});
		populateItemListThread.start();
	}
	
	private void init2(){
		PopulateSingleOrdeListThread<T> populateItemListThread = new PopulateSingleOrdeListThread<T>(list, service, mainorder);
		populateItemListThread.start();
	}
	
}
