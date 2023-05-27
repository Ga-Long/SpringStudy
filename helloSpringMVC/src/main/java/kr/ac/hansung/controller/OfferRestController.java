package kr.ac.hansung.controller;

import kr.ac.hansung.exception.OfferNotFoundException;
import kr.ac.hansung.model.ErrorResponse;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/offers")
public class OfferRestController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public ResponseEntity<List<Offer>> getOffers(){
        List<Offer> offers = offerService.getOffers();
        if(offers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //status
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable("id") int id){
        Offer offer = offerService.getOfferById(id);

        if(offer == null) // 그 id에 맞는 offer가 없으면
            throw new OfferNotFoundException(id);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> CreateOffer(@RequestBody Offer offer, UriComponentsBuilder ucBuilder){
        offerService.insertOffer(offer);

        HttpHeaders headers = new HttpHeaders();
        // ucBuilder를 만들고 {id}에
        // buildAndExpand에서 getId()로 id를 가지고 와서 넣고
        // 이를 uri로 만들고 setLocation() 한다.
        // 새롭게 offer를 만들어서 이를 위한 id를 만들어주는 작업.
        headers.setLocation(ucBuilder.path("api/offers/{id}").buildAndExpand(offer.getId()).toUri()); // id 에 buildand

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id") int id, @RequestBody Offer offer){

        Offer currentOffer = offerService.getOfferById(id);
        if(currentOffer==null){
            throw new OfferNotFoundException(id);
        }

        currentOffer.setEmail(offer.getEmail());
        currentOffer.setName(offer.getName());
        currentOffer.setText(offer.getText());

        offerService.updateOffer(currentOffer);

        return new ResponseEntity<>(currentOffer, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteOFfer(@PathVariable("id") int id){

        Offer currentOffer = offerService.getOfferById(id);
        if(currentOffer==null){
            throw new OfferNotFoundException(id);
        }

        offerService.deleteOffer(currentOffer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
