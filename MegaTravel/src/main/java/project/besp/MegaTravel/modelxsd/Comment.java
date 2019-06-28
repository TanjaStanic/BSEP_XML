package project.besp.MegaTravel.modelxsd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import project.besp.MegaTravel.model.User;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "text",
    "commentDate",
    "user",
    "accommodation_unit",
    "visible"
})
@Entity
@Table(name="comment")
public class Comment {
	@Id
    @Column(name = "id")
    private Long id;
	
	@Column(name = "text", nullable = false)
    private String text;

	@Column(name = "comment_date")
    private Date commentDate;

	@Column(name = "visible")
	private boolean visible;

	@ManyToOne
	@JoinColumn(name="client_comment")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="acc_unit_comment")
	private AccommodationUnit accommodation_unit;
	
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

	public AccommodationUnit getAccommodation_unit() {
		return accommodation_unit;
	}

	public void setAccommodation_unit(AccommodationUnit accommodation_unit) {
		this.accommodation_unit = accommodation_unit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
