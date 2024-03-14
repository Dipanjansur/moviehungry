package clone.copycat.Moviehungry.Theather;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.Show.ShowsRepository;
import clone.copycat.Moviehungry.Show.ShowsService;
import clone.copycat.Moviehungry.Theather.DTOs.AddMoviesToTheathersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.AddTheatersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.TheatherDTO;
import clone.copycat.Moviehungry.Theather.Mappers.TheatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatersService {
    private TheatersRepo theatersRepo;
    private TheatherMapper theatherMapper;
    private ShowsRepository showsRepository;
    private ShowMapper showsMapper;

    @Autowired
    public TheatersService(TheatersRepo theatersRepo, TheatherMapper theatherMapper, ShowsRepository showsRepository,ShowMapper showsMapper) {
        this.theatersRepo = theatersRepo;
        this.theatherMapper = theatherMapper;
        this.showsRepository = showsRepository;
        this.showsMapper = showsMapper;
    }

    public List<TheatherDTO> findAllTheathers() throws NosuchEntity {
        List<TheatersDAO> temptheather = theatersRepo.findAll();
        System.out.println(temptheather);
        System.out.println(temptheather.size());
        if (temptheather.isEmpty()) {
            throw new NosuchEntity("no  tethers Exists please put some fresh data");
        }
        return temptheather.stream().map(x -> theatherMapper.TheatherDAO_TheathersDTO(x)).collect(Collectors.toList());
    }

    public List<TheatherDTO> findTheatherByName(String TheatherName) {
        List<TheatersDAO> temptheather = theatersRepo.findByName(TheatherName);
        if (temptheather.isEmpty()) {
            throw new NosuchEntity("no such theaters Exists by the theatreName");
        }
        return temptheather.stream().map(x -> theatherMapper.TheatherDAO_TheathersDTO(x)).collect(Collectors.toList());
    }

    public List<TheatherDTO>findTheathersBYCity(String cityName) {
        List<TheatersDAO> temptheather = theatersRepo.findByCityname(cityName);
        if (temptheather.isEmpty()) {
            throw new NosuchEntity("no tethers Exists");
        }
        return temptheather.stream().map(x -> theatherMapper.TheatherDAO_TheathersDTO(x)).collect(Collectors.toList());
    }

//    public Optional<List<TheatherDTO>> findTheatersByMovieId(Long movieId) {
//
//    }

    public TheatherDTO createNewTheather(AddTheatersDTO addNewTheathers) {
        TheatersDAO newtheathor = theatherMapper.AddTheatersDTO_TheatersDAO(addNewTheathers);
        TheatersDAO savedData= theatersRepo.save(newtheathor);
        return theatherMapper.TheatherDAO_TheathersDTO(savedData);
    }

    public TheatherDTO addNewShows(AddMoviesToTheathersDTO addMoviesToTheathersDTO) {
        Long uuid = addMoviesToTheathersDTO.getUuid();
        Optional<TheatersDAO> retrivedDao = theatersRepo.findById(uuid);
        List<ShowDTO> jsonparseShows = addMoviesToTheathersDTO.getShowDTOs();
        List<ShowDAO> retrivedShowList = retrivedDao.get().getShowsDao();
        jsonparseShows.stream().filter(x -> {
            Optional<ShowDAO> retrived = showsRepository.findById(x.getUuid());
            if (retrived.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }).forEach(x->retrivedShowList.add(showsMapper.ShowDTO_ShowDAO(x)));
        retrivedDao.get().setShowsDao(retrivedShowList);
        return theatherMapper.TheatherDAO_TheathersDTO(theatersRepo.save(retrivedDao.get()));

    }
}
