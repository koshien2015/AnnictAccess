package cx.myhome.ckoshien.annict.rest.dto;

import java.util.List;

public class ResultDto {
	private List<ProgramsDto> programs;
	private Integer total_count;
	private Integer next_page;
	private Integer prev_page;

	public List<ProgramsDto> getPrograms() {
		return programs;
	}

	public void setPrograms(List<ProgramsDto> programs) {
		this.programs = programs;
	}

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public Integer getNext_page() {
		return next_page;
	}

	public void setNext_page(Integer next_page) {
		this.next_page = next_page;
	}

	public Integer getPrev_page() {
		return prev_page;
	}

	public void setPrev_page(Integer prev_page) {
		this.prev_page = prev_page;
	}

}
