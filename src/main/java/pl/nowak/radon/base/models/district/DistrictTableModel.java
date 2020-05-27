package pl.nowak.radon.base.models.district;

import java.util.Optional;

import javax.swing.table.AbstractTableModel;

import converter.districtConverter.DistrictStoreJsonConverter;

public class DistrictTableModel extends AbstractTableModel {
	
	
	private String[] columnsNames = {"Id","District Name"};
	private DistrictStore store;
		
	
	public Object[][] GetDistrictData(DistrictStore store){
		this.store = store;
		Object[][] rowData = new Object[store.getDistricts().size()][columnsNames.length];
		for(int i = 0 ; i < store.getDistricts().size(); i++) {
			rowData[i][1] = store.getDistricts().get(i).getDistrictName();
			rowData[i][0] = i;
		}
		
		return rowData;
	}

	public String[] getColumnsNames() {
		return columnsNames;
	}

	public void setColumnsNames(String[] columnsNames) {
		this.columnsNames = columnsNames;
	}

	public DistrictStore getStore() {
		return store;
	}

	public void setStore(DistrictStore store) {
		this.store = store;
	}

	public DistrictTableModel(DistrictStore store) {
		super();
		this.store = store;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return store.getDistricts().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnsNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return store.getDistricts();
	}

}
