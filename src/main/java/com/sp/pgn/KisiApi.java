package com.sp.pgn;

import com.sp.pgn.model.Kisi;
import com.sp.pgn.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiApi {
    @Autowired
    private final KisiRepository kisiRepository;


    //URLde belirlenen degiskenlere gore manuel olarak pageable
    @GetMapping
    public Page<Kisi> pagination(@RequestParam int pageSize,
                                 @RequestParam int pageNumber){

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return kisiRepository.findAll(pageable);
    }

    //Parametreler olarak standart page ve size degiskenleri verilir.
    //Verilmezse size varsayilan 20 alinir.page degiskenine gore sekillenir.
    @GetMapping("/p")
    public Page<Kisi> pagination(Pageable pageable){

        return kisiRepository.findAll(pageable);
    }
    //Daha performansli
    @GetMapping("/s")
    public Slice<Kisi> slice(Pageable pageable){
        return kisiRepository.findAll(pageable);
    }
}
