package project.besp.MegaTravel.modelxsd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
    @Column(name = "id")
    private Long id;
	
	@Column(name = "text", nullable = false)
    private String text;
	
	@Column(name = "user_id")
    private Long userID;
	
	@Column(name = "acc_unit_id")
    private Long accommodationUnitID;
	
	@Column(name = "comment_date")
    private Date commentDate;

	@Column(name = "visible")
	private boolean visible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getAccommodationUnitID() {
		return accommodationUnitID;
	}

	public void setAccommodationUnitID(Long accommodationUnitID) {
		this.accommodationUnitID = accommodationUnitID;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
