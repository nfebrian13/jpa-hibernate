package com.registration.app.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registration.app.dao.EmailVerificationDao;
import com.registration.app.dao.MemberDao;
import com.registration.app.model.EmailVerification;
import com.registration.app.model.Member;

@Service
@Transactional
public class RegistrationService {

	@Value("${token.expire.days}")
	private Integer tokenExpireDays;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private EmailVerificationDao emailVerificationDao;

	/** move to the top, because every method is transactional **/
//	@Transactional
	public void registrationNewMember(Member m) {
		EmailVerification ev = new EmailVerification();
		ev.setMember(m);
		ev.setToken(UUID.randomUUID().toString());
		ev.setExpire(LocalDateTime.now().plusDays(tokenExpireDays));

		memberDao.save(m);
		emailVerificationDao.save(ev);
	}

//	@Transactional
	public void tokenVerification(String token) {
		EmailVerification v = emailVerificationDao.findByToken(token);
		if (v != null) {
			Member m = v.getMember();
			m.setEmailVerification(true);
			emailVerificationDao.delete(v);
		}
	}
}
