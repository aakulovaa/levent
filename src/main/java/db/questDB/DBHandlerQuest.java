package db.questDB;

import db.DBHandler;
import models.quest.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandlerQuest {
    private Connection dbConnectionQuest;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionQuest() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionQuest);
    }

    public void questsFilling(Quest quest) {
        String insertQuest = "INSERT INTO " + QuestsConst.QUESTS_TABLE + "(" +
                QuestsConst.QUEST_NAME +"," + QuestsConst.QUEST_COUNT_PLAYER +
                "," +  QuestsConst.QUEST_AGE_LIMIT + "," + QuestsConst.QUEST_DESCRIPTION +","
                + QuestsConst.QUEST_LOCATION +","
                + QuestsConst.QUEST_IMAGE_LINK +"," + QuestsConst.QUEST_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionQuest().prepareStatement(insertQuest);
            prSt.setString(1,quest.getQuestName());
            prSt.setString(2,quest.getQuestCountPlayers());
            prSt.setString(3,quest.getQuestAgeLimit());
            prSt.setString(4,quest.getQuestDescription());
            prSt.setString(5,quest.getQuestLocation());
            prSt.setString(6,quest.getQuestImageLink());
            prSt.setString(7,quest.getQuestImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet questsGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + QuestsConst.QUESTS_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionQuest().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void questsCleaning(){

        String delete = "DELETE FROM " + QuestsConst.QUESTS_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionQuest().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
