package com.dotcms.util.version;

import com.dotcms.rendering.velocity.viewtools.content.ContentMap;
import com.dotmarketing.beans.Identifier;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.DotStateException;
import com.dotmarketing.business.FactoryLocator;
import com.dotmarketing.business.Versionable;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import org.apache.velocity.tools.view.tools.ViewTool;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VersionUtilTool implements ViewTool {

	@Override
	public void init(Object initData) {
	}

	public Timestamp getModDateOfOriginalVersion(ContentMap contentMap) throws DotDataException, DotSecurityException {
		Contentlet contentlet = contentMap.getContentObject();
		List<Versionable> versions = APILocator.getVersionableAPI().findAllVersions(contentlet);
		List<Date> allDates = versions.stream()
//				.filter(versionable -> !versionable.isArchived())
				.map(Versionable::getModDate)
				.sorted()
				.collect(Collectors.toList());
		return new Timestamp(allDates.get(0).getTime());

//		Contentlet contentlet = contentMap.getContentObject();
//		String id = contentlet.getIdentifier();
//		Identifier identifier = APILocator.getIdentifierAPI().find(id);
//		List<Contentlet> versions = FactoryLocator.getContentletFactory()
//				.findAllVersions(identifier, true, null);
//		List<Date> allDates = versions.stream()
//				.map(Versionable::getModDate)
//				.sorted()
//				.collect(Collectors.toList());
//		return new Timestamp(allDates.get(0).getTime());
	}

}
