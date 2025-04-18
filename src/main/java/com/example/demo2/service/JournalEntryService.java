package com.example.demo2.service;

import com.example.demo2.entity.JournalEntry;
import com.example.demo2.entity.User;
import com.example.demo2.repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService  {

    @Autowired
    private JournalEntryRepo journalRepo;

    @Autowired
    private UserEntryService userEntryService;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);


    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user  = userEntryService.findByUserName(userName);

            journalEntry.setDate(LocalDateTime.now());
            JournalEntry save = journalRepo.save(journalEntry);

            user.getJournalEntries().add(save);
            userEntryService.saveUser(user);
            logger.info("Successfully inserted the journal");
        }
        catch (Exception e){
            logger.info("A error has been occurred");
            throw new RuntimeException("An error occurred while saving the entry.", e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalRepo.save(journalEntry);
    }


    public List<JournalEntry> getAll(){
        return journalRepo.findAll();
    }


    public Optional<JournalEntry> findById(ObjectId id){
        return journalRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            User user  = userEntryService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed){
                userEntryService.saveUser(user);
                journalRepo.deleteById(id);
            }
        }
        catch (Exception e){
            log.error("Error: ",e);
            throw new RuntimeException("An error occurred while deleting the entry "+e);
        }
        return removed;
    }



}
