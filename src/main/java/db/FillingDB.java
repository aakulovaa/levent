package db;

import db.cinemaDB.DBHandlerCinema;
import db.concertDB.DBHandlerConcert;
import db.questDB.DBHandlerQuest;
import db.sportDB.DBHandlerDance;
import db.sportDB.DBHandlerRun;
import db.theatreDB.DBHandlerTheatre;
import models.cinema.Movie;
import models.concert.Concert;
import models.quest.Quest;
import models.sport.Dance;
import models.sport.Run;
import models.theatre.Performance;
import parser.*;
import posts.cinema.MoviePost;
import posts.concert.ConcertPost;
import posts.quest.QuestPost;
import posts.sport.DancePost;
import posts.sport.SportPost;
import posts.theatre.PerformancePost;

import java.util.List;
import java.util.Objects;

public class FillingDB {
    private void fillingMovies() {
        DBHandlerCinema db = new DBHandlerCinema();
        String imgSource;
        String pageName = "movie/";
        MovieParser movieParser = new MovieParser();
        List<MoviePost> parser = movieParser.parser();
        for (int i = 0; i<parser.getLast().getMovieID(); i++)
        {
            MoviePost parsingCounting = parser.get(i);
            String movieName = parsingCounting.getTitle().replaceAll("\u0000", "");
            String movieLink = parsingCounting.getMovieLink().replaceAll("\u0000", "");
            String movieDateRelease = parsingCounting.getYearRelease().replaceAll("\u0000", "");
            String movieLength = parsingCounting.getLength().replaceAll("\u0000", "");
            String movieAgeLimit = parsingCounting.getAge().replaceAll("\u0000", "");
            String movieGenre = parsingCounting.getGenre().replaceAll("\u0000", "");
            String movieDirector = parsingCounting.getDirector().replaceAll("\u0000", "");
            String movieDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String movieImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            LoadImage loadMovieImage = new LoadImage();
            imgSource = loadMovieImage.loadImage(movieImageLink,i,pageName);
            String movieImageSource = imgSource;
            System.out.println(imgSource);

            Movie movie = new Movie(movieName,movieLink,movieDateRelease,
                    movieLength,movieAgeLimit,movieGenre,movieDirector,movieDescription,movieImageLink,movieImageSource);

            db.moviesFilling(movie);

        }
    }

    private void fillingPerformances() {
        DBHandlerTheatre db = new DBHandlerTheatre();
        String imgSource;
        String pageName = "theatre/";
        PerformanceParser performanceParser = new PerformanceParser();
        List<PerformancePost> parser = performanceParser.parser();
        for (int i = 0; i<parser.getLast().getPerformanceID(); i++)
        {
            PerformancePost parsingCounting = parser.get(i);
            String performanceName = parsingCounting.getName().replaceAll("\u0000", "");
            String performanceLink = parsingCounting.getPerformanceLink().replaceAll("\u0000", "");
            String date = parsingCounting.getDateRelease().replaceAll("\u0000", "");
            String[] dateT = date.split(" ");
            String performanceDate = dateT[0] + " " + dateT[1];
            if (Objects.equals(dateT[1], "и")){
                performanceDate = dateT[0] + " " + dateT[dateT.length-1];
            }
            String performanceAddress = parsingCounting.getAddressTheatre().replaceAll("\u0000", "");
            String performanceGenre = parsingCounting.getGenre().replaceAll("\u0000", "");
            String performanceLength = parsingCounting.getLength().replaceAll("\u0000", "");
            String performanceAgeLimit = parsingCounting.getAge().replaceAll("\u0000", "");
            String performanceDirector = parsingCounting.getDirector().replaceAll("\u0000", "");
            String performanceDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String performanceImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            LoadImage loadTheatreImage = new LoadImage();
            imgSource = loadTheatreImage.loadImage(performanceImageLink,i,pageName);
            String performanceImageSource = imgSource;
            System.out.println(imgSource);

            Performance performance = new Performance(performanceName,performanceLink,performanceDate,performanceAddress,performanceGenre,
                    performanceLength,performanceAgeLimit,performanceDirector,performanceDescription,performanceImageLink,performanceImageSource);

            db.performancesFilling(performance);

        }
    }

    private void fillingConcerts() {
        DBHandlerConcert db = new DBHandlerConcert();
        String imgSource;
        String pageName = "concert/";
        ConcertParser concertParser = new ConcertParser();
        List<ConcertPost> parser = concertParser.parser();
        for (int i = 0; i<parser.getLast().getConcertID(); i++)
        {
            ConcertPost parsingCounting = parser.get(i);
            String concertName = parsingCounting.getName().replaceAll("\u0000", "");
            String concertLink = parsingCounting.getConcertLink().replaceAll("\u0000", "");
            String date = parsingCounting.getDateRelease().replaceAll("\u0000", "");
            String[] dateT = date.split(" ");
            String concertDate = dateT[0] + " " + dateT[1];
            String concertAddress = parsingCounting.getAddressConcert().replaceAll("\u0000", "");
            String concertGenre = parsingCounting.getGenre().replaceAll("\u0000", "");
            String concertAgeLimit = parsingCounting.getAge().replaceAll("\u0000", "");
            String concertDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String concertImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            LoadImage loadConcertImage = new LoadImage();
            imgSource = loadConcertImage.loadImage(concertImageLink,i,pageName);
            String concertImageSource = imgSource;
            System.out.println(imgSource);

            Concert concert = new Concert(concertName,concertLink,concertDate,concertAddress,concertGenre,
                    concertAgeLimit,concertDescription,concertImageLink,concertImageSource);

            db.concertsFilling(concert);

        }
    }

    private void fillingQuests() {
        DBHandlerQuest db = new DBHandlerQuest();
        String imgSource;
        String pageName = "quest/";
        QuestParser questParser = new QuestParser();
        List<QuestPost> parser = questParser.parser();
        for (int i = 0; i<parser.getLast().getQuestID(); i++)
        {
            QuestPost parsingCounting = parser.get(i);
            String questName = parsingCounting.getName().replaceAll("\u0000", "");
            String questCountPlayer = parsingCounting.getCountPlayer().replaceAll("\u0000", "");
            String questAgeLimit = parsingCounting.getAge().replaceAll("\u0000", "");
            String questDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String questLocation = parsingCounting.getLocation().replaceAll("\u0000", "");
            String questImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            LoadImage loadQuestImage = new LoadImage();
            imgSource = loadQuestImage.loadImage(questImageLink,i,pageName);
            String questImageSource = imgSource;
            System.out.println(imgSource);

            Quest quest = new Quest(questName,questCountPlayer,
                    questAgeLimit,questDescription,questLocation,questImageLink,questImageSource);

            db.questsFilling(quest);

        }
    }

    private void fillingDance() {
        DBHandlerDance db = new DBHandlerDance();
        String imgSource;
        String pageName = "dance/";
        DanceParser danceParser = new DanceParser();
        List<DancePost> parser = danceParser.parser();
        for (int i = 0; i<parser.getLast().getDanceID(); i++)
        {
            DancePost parsingCounting = parser.get(i);
            String danceStudioName = parsingCounting.getNameDanceStudio().replaceAll("\u0000", "");
            String danceAddress = parsingCounting.getAddress().replaceAll("\u0000", "");
            String danceDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String danceImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            imgSource = "/image/" + pageName + i + ".jpeg";
            String danceImageSource = imgSource;
            System.out.println(imgSource);

            Dance dance = new Dance(danceStudioName,danceAddress,
                    danceDescription,danceImageLink,danceImageSource);

            db.danceFilling(dance);

        }
    }

    private void fillingRun() {
        DBHandlerRun db = new DBHandlerRun();
        String imgSource;
        String pageName = "run/";
        RunParser runParser = new RunParser();
        List<SportPost> parser = runParser.parser();
        for (int i = 0; i<parser.getLast().getSportID(); i++)
        {
            SportPost parsingCounting = parser.get(i);
            String runName = parsingCounting.getName().replaceAll("\u0000", "");
            String runLogo = parsingCounting.getLogeDesc().replaceAll("\u0000", "");
            String runLink = parsingCounting.getSportLink().replaceAll("\u0000", "");
            String runAddress = parsingCounting.getAddress().replaceAll("\u0000", "");
            String runDate = parsingCounting.getDateStart().replaceAll("\u0000", "");
            String runDescription = parsingCounting.getDescription().replaceAll("\u0000", "");
            String runImageLink = parsingCounting.getImageLink().replaceAll("\u0000", "");
            LoadImage loadDanceImage = new LoadImage();
            imgSource = loadDanceImage.loadImage(runImageLink,i,pageName);
            String runImageSource = imgSource;
            System.out.println(imgSource);

            Run run = new Run(runName,runLogo,runLink,runAddress,runDate,
                    runDescription,runImageLink,runImageSource);

            db.runFilling(run);

        }
    }

    public void filling(){
        DBHandlerCinema dbHandlerCinema = new DBHandlerCinema();
        dbHandlerCinema.moviesCleaning();
        fillingMovies();

        DBHandlerTheatre dbHandlerTheatre = new DBHandlerTheatre();
        dbHandlerTheatre.performancesCleaning();
        fillingPerformances();

        DBHandlerConcert dbHandlerConcert = new DBHandlerConcert();
        dbHandlerConcert.concertsCleaning();
        fillingConcerts();

        DBHandlerQuest dbHandlerQuest = new DBHandlerQuest();
        dbHandlerQuest.questsCleaning();
        fillingQuests();

        DBHandlerDance dbHandlerDance = new DBHandlerDance();
        dbHandlerDance.danceCleaning();
        fillingDance();

        DBHandlerRun dbHandlerRun = new DBHandlerRun();
        dbHandlerRun.runCleaning();
        fillingRun();
    }

}
