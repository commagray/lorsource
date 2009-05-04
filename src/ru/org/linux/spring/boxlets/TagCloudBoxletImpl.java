/*
 * Copyright 1998-2009 Linux.org.ru
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.org.linux.spring.boxlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import ru.org.linux.spring.dao.TagDaoImpl;
import ru.org.linux.util.ProfileHashtable;
import ru.org.linux.site.Template;

public class TagCloudBoxletImpl extends SpringBoxlet {
  private TagDaoImpl tagDao;

  public TagDaoImpl getTagDao() {
    return tagDao;
  }

  public void setTagDao(TagDaoImpl tagDao) {
    this.tagDao = tagDao;
  }

  protected ModelAndView getData(HttpServletRequest request, HttpServletResponse response) {
    final ProfileHashtable profile = Template.getTemplate(request).getProf();
    final int i = profile.getInt("tags");
    return new ModelAndView("boxlets/tagcloud", "tags", getTagDao().getTags(i));
  }
}
