package ccc.springboot.coconut.service;

import ccc.springboot.coconut.model.entity.VirusStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidVarius {
  public static final String URL_LINK =
      "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
  List<VirusStats> statsArray = new ArrayList<>();

  public List<VirusStats> getStatsArray() {
    return statsArray;
  }

  @PostConstruct
  @Scheduled(cron = "* * 1 * * *")
  public void fetchVirusData() throws IOException, InterruptedException {
    List<VirusStats> newStatsArray = new ArrayList<>();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_LINK)).build();

    HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    StringReader csvBodyReader = new StringReader(httpResponse.body());

    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
    for (CSVRecord record : records) {
      VirusStats caseNum = new VirusStats();
      caseNum.setState(record.get("Province/State"));
      caseNum.setCountry(record.get("Country/Region"));
      caseNum.setLastConfirmedNum(Integer.parseInt(record.get(record.size() - 1)));
      newStatsArray.add(caseNum);
    }

    this.statsArray = newStatsArray;
  }
}
