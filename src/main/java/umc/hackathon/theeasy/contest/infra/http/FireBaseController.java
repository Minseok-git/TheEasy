package umc.hackathon.theeasy.contest.infra.http;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import umc.hackathon.theeasy.contest.application.FireBaseService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/contest")
public class FireBaseController {

    private final FireBaseService fireBaseService;

    @Autowired
    public FireBaseController(FireBaseService fireBaseService) {
        this.fireBaseService = fireBaseService;
    }

    @PostMapping("/banner")
    public String uploadBanner(@RequestParam("file") MultipartFile file, @RequestParam String nameFile)
            throws IOException, FirebaseAuthException {
        if (file.isEmpty()) {
            return "File is empty";
        }
        return fireBaseService.uploadFiles(file, nameFile);
    }
}
