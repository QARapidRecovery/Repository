package RapidRecovery.com.PageObject.enums;

public enum LocalizedLanguages {

    Portuguese("Pt-Br", "li:nth-child(12)","Português (Brasil)"),
    China("Zh-CN", "li:nth-child(1)","中文(中华人民共和国)"),
    French("fr","li:nth-child(7)","français (France)"),
    German("de","li:nth-child(8)","Deutsch (Österreich)"),
    English("en-us","li:nth-child(3)","English (Canada)"),
    Spanish("es","li:nth-child(13)","español (España, alfabetización internacional)"),
    Korean("ko","li:nth-child(11)","한국어(대한민국)"),
    Japan("ja","li:nth-child(10)","日本語 (日本)"),
    ;


    private String languageCss;
    private String LanguageKey;
    private String languageName;

    LocalizedLanguages(String LanguageKey, String languageCss,String languageName ) {
        this.LanguageKey = LanguageKey;
        this.languageCss = languageCss;
        this.languageName = languageName;
    }


    public String getLanguageName() {
        return languageName;
    }

    public String getLanguageCss() {
        return languageCss;
    }

    public String getLanguageKey() {
        return LanguageKey;
    }

    public static LocalizedLanguages getLanguageByKey(String languageKey) {
        for (LocalizedLanguages lang : LocalizedLanguages.values()) {
            if (lang.getLanguageKey().equalsIgnoreCase(languageKey)) {
                return lang;
            }
        }

        throw new EnumConstantNotPresentException(Enum.class, languageKey);
    }

    public void printLanguageByKey( ) {

        String languageKey = getLanguageKey();
        switch (languageKey) {
            case "Pt-Br":
                System.out.println("[Portuguese]");
                break;
            case "Zh-CN":
                System.out.println("[Chinese]");
                break;
            case "fr":
                System.out.println("[French]");
                break;
            case "de":
                System.out.println("[German]");
                break;
            case "en-us":
                System.out.println("[English]");
                break;
            case "es":
                System.out.println("[Spanish]");
                break;
            case "ja":
                System.out.println("[Japanese]");
                break;
            case "ko":
                System.out.println("[Korean]");
                break;
        }
    }
}