package pl.nowak.radon.base.models.geologicalformation;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import pl.nowak.radon.base.models.district.DistrictStore;

public class GeologicalFormationTableModel extends AbstractTableModel {
	
	
	private String[] columnsNames = {"Id","Formation Description", "District Name"};
	private GeologicalFormationStore store;
	private JTable table;
		
	
	public Object[][] GetGeologicalFormationtData(GeologicalFormationStore store){
		this.store = store;
		Object[][] rowData = new Object[store.getGeologicalFormations().size()][columnsNames.length];
		for(int i = 0 ; i < store.getGeologicalFormations().size(); i++) {
			rowData[i][0] = i;
			rowData[i][1] = store.getGeologicalFormations().get(i).getFormationDescription();
			rowData[i][2] = store.getDistricts().get(i).getDistrictName();
		}
		
		return rowData;
	}
	
	public void addRow(String geologicalFormationDescription, int geologicalFormationtId, String districtName, JTable table) {
		table.add(table, new Object[] {geologicalFormationtId, geologicalFormationDescription,districtName}, -1);
	}

	public String[] getColumnsNames() {
		return columnsNames;
	}

	public void setColumnsNames(String[] columnsNames) {
		this.columnsNames = columnsNames;
	}

	public GeologicalFormationStore getStore() {
		return store;
	}

	public void setStore(GeologicalFormationStore store) {
		this.store = store;
	}

	public GeologicalFormationTableModel(GeologicalFormationStore store) {
		super();
		this.store = store;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return store.getGeologicalFormations().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnsNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return store.getGeologicalFormations();
	}
}