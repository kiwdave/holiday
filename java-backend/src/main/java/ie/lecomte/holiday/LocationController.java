package ie.lecomte.holiday;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocationController {
    private final LocationRepository locationRepository;
    private final CountryRepository countriesRepository;

    @GetMapping("/locations-with-position/{language}")
    public List<Location> getLocationsWithPositions(@PathVariable String language) {

        var countriesWithLanguage = locationRepository.findAll().stream()
                .filter(l -> l.getValues().stream().anyMatch(loc -> loc.getLanguage().equalsIgnoreCase(language))).toList();

        countriesWithLanguage.forEach(location -> {
            location.getValues().removeIf(l -> l.getLanguage().compareToIgnoreCase(language) != 0);
        });

        return countriesWithLanguage;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countriesRepository.findAll();
    }

//    @PostMapping("/country")
//    public Country addCountry()
}
