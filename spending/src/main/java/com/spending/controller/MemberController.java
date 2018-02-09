package com.spending.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spending.beans.Member;
import com.spending.repository.MemberRepository;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	MemberRepository memberRepository;
	
	// Get All Members
	@GetMapping("/members")
	public List<Member> getAllMembers()
	{
		return memberRepository.findAll();
	}
	
    // Create a new Member
	@PostMapping("/members")
	public Member createMember(@Valid @RequestBody Member member)
	{
		return memberRepository.save(member);
	}
	
    // Get a Single Member
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memberId) {
	    Optional<Member> m = memberRepository.findById(memberId);
	    if(!m.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    Member member = m.get();
	    return ResponseEntity.ok().body(member);
	}

    // Update a Member
	public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memberId, 
                                       @Valid @RequestBody Member memberDetails) {
    Optional<Member> m = memberRepository.findById(memberId);
    if(!m.isPresent()) {
        return ResponseEntity.notFound().build();
    }
    Member member = m.get();
    member.setName(memberDetails.getName());
    
    Member updatedMember = memberRepository.save(member);
    return ResponseEntity.ok(updatedMember);
	}
	
	
    // Delete a Member
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Optional<Member> m = memberRepository.findById(noteId);
	    if(!m.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    Member member = m.get();
	    memberRepository.delete(member);
	    return ResponseEntity.ok().build();
	}
	
}