package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-30-17:16
 */
public class PortalItem extends TbItem {

    public String[] getImages() {
        String images = this.getImage();
        if (images != null && !images.equals("")) {
            String[] imgs = images.split(",");
            return imgs;
        }
        return null;
    }
}
