package com.marvik.apis.dbcrudgen;

import java.util.ArrayList;
import java.util.List;

import com.marvik.apis.dbcrudgen.creator.php.PHPCrudCreator;
import com.marvik.apis.dbcrudgen.database.connection.project.ProjectDatabaseConnectionProperties;
import com.marvik.apis.dbcrudgen.projects.php.configuration.PHPProjectConfiguration;
import com.marvik.apis.dbcrudgen.schemamodels.columns.Columns;
import com.marvik.apis.dbcrudgen.schemamodels.columns.keys.PrimaryKeys;
import com.marvik.apis.dbcrudgen.schemamodels.constraints.Constraints;
import com.marvik.apis.dbcrudgen.schemamodels.database.Database;
import com.marvik.apis.dbcrudgen.schemamodels.datatypes.DataType;
import com.marvik.apis.dbcrudgen.schemamodels.tables.Table;
import com.marvik.apis.dbcrudgen.sql.parser.SQLParser;
import com.marvik.apis.dbcrudgen.templates.php.PHPColumnsCrudTemplate;
import com.marvik.apis.dbcrudgen.templates.sql.SQLTablesTemplate;

public class Main {
	public static void main(String[] args) {

		testPHPCrudGenerator();
	}

	private static void testPHPCrudGenerator() {
		// TODO Auto-generated method stub
		SQLTablesTemplate sQLTablesTemplate = new SQLTablesTemplate();
		// System.out.println(sQLTablesTemplate.getTemplate());

		PHPColumnsCrudTemplate columnsCrudTemplate = new PHPColumnsCrudTemplate();
		// System.out.println(columnsCrudTemplate.getTemplate());

		SQLParser sqlParser = new SQLParser();
		/*
		 * Database database = sqlParser.getDatabaseSchemas(new SQLReader(),
		 * TestRes.TEST_SQL_FILE);
		 * System.out.println(database.getDatabaseName()); for (Table table :
		 * database.getTables()) { System.out.println(table.getTableName());
		 * System.out.println(table.getTableSql()); }
		 */

		List<Table> tablesList = new ArrayList<Table>();

		addTableFirstAids(tablesList);
		addTableFirstAidsCategories(tablesList);

		Table[] tables = new Table[tablesList.size()];
		for (int i = 0; i < tablesList.size(); i++) {
			tables[i] = tablesList.get(i);
		}

		Database database = new Database("where_there_is_no_doc", tables);

		PHPProjectConfiguration phpProjectConfiguration = new PHPProjectConfiguration("where_there_is_no_doc");
		phpProjectConfiguration.setProjectStorageDirectory("C:\\xampp\\htdocs\\where_there_is_no_doc\\");
		phpProjectConfiguration.setProjectCRUDScriptsStorageDirectory(
				"C:\\xampp\\htdocs\\where_there_is_no_doc\\scripts\\php\\database\\crud\\");
		phpProjectConfiguration.setProjectPHPDatabaseAPIScriptsStorageDirectory(
				"C:\\xampp\\htdocs\\where_there_is_no_doc\\scripts\\php\\database\\core-apis\\");
		phpProjectConfiguration.setProjectSQLScriptsStorageDirectory(
				"C:\\xampp\\htdocs\\where_there_is_no_doc\\scripts\\php\\database\\sql\\");

		ProjectDatabaseConnectionProperties projectDatabaseConnectionProperties = new ProjectDatabaseConnectionProperties(
				"localhost", "root", "", "where_there_is_no_doc");

		PHPCrudCreator phpCrudCreator = new PHPCrudCreator();
		phpCrudCreator.setProjectConfiguration(phpProjectConfiguration);
		phpCrudCreator.setProjectDatabaseConnectionProperties(projectDatabaseConnectionProperties);
		phpCrudCreator.createProject(database);

	}

	/**
	 * @param tablesList
	 */
	private static void addTableFirstAids(List<Table> tablesList) {
		List<Columns> firstAidColumnList = new ArrayList<Columns>();
		firstAidColumnList
				.add(new Columns("ailment", new DataType("varchar", new Constraints("varchar(128) NOT NULL"))));
		firstAidColumnList.add(new Columns("ailment_information", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_causes", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_prevention", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_signs", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_symptoms", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_cautions", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_medication", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_treatment", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_treatment_precautions", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_treatment_position", new DataType("text", new Constraints())));
		firstAidColumnList.add(new Columns("ailment_short_notes", new DataType("text", new Constraints())));

		Columns[] firstAidColumns = new Columns[firstAidColumnList.size()];
		for (int i = 0; i < firstAidColumnList.size(); i++) {
			firstAidColumns[i] = firstAidColumnList.get(i);
		}
		String tableSql = "CREATE TABLE IF NOT EXISTS `firstaids`"
				+ " (`ailment` varchar(128) NOT NULL,`ailment_information` text,"
				+ "`ailment_causes` text,`ailement_prevention` text,`ailment_signs` text,"
				+ "`ailment_symptoms` text,`ailment_cautions` text,`ailment_medication` text,"
				+ "`ailment_treatmeant` text,`ailment_treatmeant_precautions` text,"
				+ "`ailment_treatment_position` text, `ailment_short_notes` text,"
				+ "`id_firstaid` integer primary key auto_increment);";

		PrimaryKeys primaryKeys = new PrimaryKeys(new String[] { "id_firstaid", });

		tablesList.add(new Table("firstaids", firstAidColumns, tableSql, primaryKeys, null, null));
	}

	/**
	 * @param tablesList
	 */
	private static void addTableFirstAidsCategories(List<Table> tablesList) {
		List<Columns> firstAidCategoriesColumnList = new ArrayList<Columns>();
		firstAidCategoriesColumnList.add(new Columns("category_name", new DataType("varchar", new Constraints("varchar(128) NOT NULL"))));
		
		Columns[] firstAidColumns = new Columns[firstAidCategoriesColumnList.size()];
		
		for (int i = 0; i < firstAidCategoriesColumnList.size(); i++) {
			firstAidColumns[i] = firstAidCategoriesColumnList.get(i);
		}
		String tableSql = "CREATE TABLE IF NOT EXISTS `firstaid_categories` ("
				+ "`id_firstaid_category` int(11) NOT NULL," + " `category_name` varchar(128) NOT NULL)";

		PrimaryKeys primaryKeys = new PrimaryKeys(new String[] { "id_firstaid_category", });

		tablesList.add(new Table("firstaid_categories", firstAidColumns, tableSql, primaryKeys, null, null));
	}

	private static void print(String string) {
		System.err.println(string);
	}
}
