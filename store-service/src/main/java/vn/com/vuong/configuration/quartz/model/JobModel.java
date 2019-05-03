package vn.com.vuong.configuration.quartz.model;

import java.io.Serializable;

import org.quartz.Job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.configuration.quartz.job.CategoryJob;
import vn.com.vuong.configuration.quartz.job.WareHouseJob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private JopType jobType;
	private Integer repeatCount;
	private Long repeatInterval;
	private Integer retryMax = 3;
	private Long retryDelay = 0l;
	private boolean pause = false;
	private int retryType = 0;
	private Class<? extends Job> jobClass;
	
	public void setJobClass() {
		Class<? extends Job> clazz = null;
		switch (jobType) {
		case WareHouseJob:
			clazz = WareHouseJob.class;
			break;
		case CategoryJob:
			clazz = CategoryJob.class;
			break;
		default:
			clazz = CategoryJob.class;
			break;
		}
		this.setJobClass(clazz);
	}
}
