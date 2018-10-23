package com.github.xingli13.pipeline;

import com.github.xingli13.dao.GithubRepoDao;
import com.github.xingli13.entity.GithubRepo;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author xingli13
 * @date 2018/10/23
 */
@Slf4j
public class SqlPipeline implements Pipeline {
	@Override
	public void process(ResultItems resultItems, Task task) {
		GithubRepo repo = resultItems.get("repo");
		if (!GithubRepoDao.insertRepo(repo)) {
			log.error("error insert:" + repo);
		}
	}
}
