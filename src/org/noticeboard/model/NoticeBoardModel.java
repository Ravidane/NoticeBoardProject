package org.noticeboard.model;

import java.security.Timestamp;
import java.sql.Date;

public class NoticeBoardModel {

	private int NoticeId;
	private int CategoryId;
	private String Title;
	private String updateTitle;
	private String Description;
	private String publishDate;
	private String disableDate;
	private int catId;
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	private int designationId;

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public int getNoticeId() {
		return NoticeId;
	}

	public void setNoticeId(int noticeId) {
		NoticeId = noticeId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getDisableDate() {
		return disableDate;
	}

	public void setDisableDate(String disableDate) {
		this.disableDate = disableDate;
	}

	public String getupdateTitle() {
		return updateTitle;
	}

	public void setupdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

}
