package com.marvik.apis.dbcrudgen.templates.android;

import java.io.IOException;

import com.marvik.apis.dbcrudgen.filepaths.templates.TemplatesFilePath;
import com.marvik.apis.dbcrudgen.templates.CrudTemplates;

public class AndroidMethodColumnsCrudDataTypeLongTemplate extends CrudTemplates {

	public AndroidMethodColumnsCrudDataTypeLongTemplate()
	{

	}

	@Override
	public String openTemplate(String templateFilePath) throws IOException {
		// TODO Auto-generated method stub
		return super.openTemplate(templateFilePath);
	}

	/*
	 * Returns the columns CRUD template
	 */
	@Override
	public String getTemplate() {
		// TODO Auto-generated method stub
		try {
			return super.getTemplate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Returns the columns CRUD template file path
	 */
	@Override
	public String getTemplateFilePath() {
		// TODO Auto-generated method stub
		return TemplatesFilePath.AndroidTemplatesFilePaths.ANDROID_METHOD_COLUMNS_CRUD_DATATYPE_LONG_TEMPLATE_FILE_PATH;
	}

}
