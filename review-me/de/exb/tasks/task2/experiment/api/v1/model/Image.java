package de.exb.tasks.task2.experiment.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
@JsonProperty()
	private String fileName;
	public String description;

	public Image(final String filename, final String aDescription) {
		this.fileName = filename;
		this.description = aDescription;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Image))
			return false;

		final Image image = (Image) o;

		if (fileName != null ? !fileName.equals(image.fileName) : image.fileName != null)
			return false;
		return true;
	}


}
