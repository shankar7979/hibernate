package org.com.model.one_to_many;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "group1")
public class Group {

	@Id
	@Column(nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gr_id;
	private String gr_name;
	@ManyToMany
	// @OneToMany(cascade={CascadeType.ALL})
	// @ManyToOne
	@JoinColumn(name = "story_id")
	@IndexColumn(name = "idx1")
	private Story story[];

	public int getGr_id() {
		return gr_id;
	}

	public void setGr_id(int gr_id) {
		this.gr_id = gr_id;
	}

	public String getGr_name() {
		return gr_name;
	}

	public void setGr_name(String gr_name) {
		this.gr_name = gr_name;
	}

	public Story[] getStory() {
		return story;
	}

	public void setStory(Story[] story) {
		this.story = story;
	}
}
