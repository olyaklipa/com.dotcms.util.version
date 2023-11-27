package com.dotcms.util.version;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

public class VersionUtilToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "versiontool";
    }

    @Override
    public String getScope () {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname () {
        return VersionUtilTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

        VersionUtilTool viewTool = new VersionUtilTool();
        viewTool.init( initData );

        setScope( ViewContext.APPLICATION );

        return viewTool;
    }

}