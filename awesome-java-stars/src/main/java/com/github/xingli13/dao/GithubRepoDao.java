package com.github.xingli13.dao;

import com.github.xingli13.entity.GithubRepo;

/**
 * @author xingli13
 * @date 2018/10/23
 */
public class GithubRepoDao {
	public static boolean insertRepo(GithubRepo repo) {
		String sql = "INSERT INTO REPO (NAME, AUTHOR, URL, STAR, FORK) VALUES (?,?,?,?,?)";
		int key = BaseDao.insert(sql, repo.getName(), repo.getAuthor(), repo.getUrl(), repo.getStar(), repo.getFork());
		return key > 0;
	}
}
