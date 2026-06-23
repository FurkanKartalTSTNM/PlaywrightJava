import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {
        // Playwright'ı başlatıyoruz
        try (Playwright playwright = Playwright.create()) {

            // Tarayıcıyı açıyoruz.
            // setHeadless(false) ayarı, tarayıcının ekranda görünür şekilde açılmasını sağlar.
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
            Browser browser = playwright.chromium().launch(options);

            // Yeni bir sekme (sayfa) açıyoruz
            Page page = browser.newPage();

            // İstediğimiz web sitesine gidiyoruz
            System.out.println("Web sitesine gidiliyor...");
            page.navigate("https://playwright.dev");

            // Sayfanın başlığını alıp konsola yazdırıyoruz
            String sayfaBasligi = page.title();
            System.out.println("Sayfanın Başlığı: " + sayfaBasligi);

            // Tarayıcıyı kapatıyoruz
            browser.close();
            System.out.println("Test başarıyla tamamlandı!");
        }
    }
}
