package gui.model;

import service.model.Area;

public class AreaBlock extends Block {
	private Area area;
	
	public AreaBlock(Area area) {
		super(area.getLocal(), "");
		this.area = area;
	}
	
	public Area getArea( ) {
		return this.area;
	}

}
