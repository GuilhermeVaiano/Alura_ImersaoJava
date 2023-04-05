package main;

public enum API {

    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtractorImdb()),
    IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtractorImdb()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtractorNasa()),
	LANGUAGE_RANK("http://localhost:8080/languages", new ExtractorLang());

    private String url;
    private ExtractorContent extrator;
    
    API(String url, ExtractorContent extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtractorContent getExtrator() {
        return extrator;
    }
}
