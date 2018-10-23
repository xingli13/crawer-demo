package com.github.xingli13.entity;

import lombok.Data;

/**
 * @author xingli13
 * Created by xingli13 on 2018/10/22.
 */
@Data
public class GithubRepo implements Comparable {
	private String author;
	private String name;
	private String url;
	private int star;
	private int fork;

	public void setStar(String star) {
		this.star = Integer.parseInt(star.replace(",", "").trim());
	}

	public void setFork(String fork) {
		this.fork = Integer.parseInt(fork.replace(",", "").trim());
	}

	public int compareTo(Object o) {
		GithubRepo repo = ((GithubRepo) o);
		if (this.star > repo.getStar()) {
			return 1;
		} else if (this.star < repo.getStar()) {
			return -1;
		} else {
			return this.fork > repo.getFork() ? 1 : -1;
		}
	}
}
