package pl.nowak.radon.base.models.district;

import java.util.Optional;

import javax.swing.table.AbstractTableModel;

import converter.districtConverter.DistrictStoreJsonConverter;

public class DistrictTableModel extends AbstractTableModel {
	
	
	private String[] columnsNames = {"Id","District Name"};
	private DistrictStore store;
		
	
	public Object[][] GetDistrictData(String jsonFilename){
		DistrictStore store = (DistrictStore) new DistrictStoreJsonConverter(jsonFilename).fromJson().get();
		Object[][] rowData = new Object[columnsNames.length][store.getDistricts().size()];
		for(int i = 0 ; i < store.getDistricts().size(); i++) {
			rowData[1][i] = store.getDistricts().get(i).getDistrictName();
			rowData[0][i] = i;
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
