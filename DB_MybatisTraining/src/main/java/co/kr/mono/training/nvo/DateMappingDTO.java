package co.kr.mono.training.nvo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateMappingDTO {
	
	LocalDateTime localDateTime ;
	java.sql.Timestamp sqlTimeStamp ;
	
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public java.sql.Timestamp getSqlTimeStamp() {
		return sqlTimeStamp;
	}
	public void setSqlTimeStamp(java.sql.Timestamp sqlTimeStamp) {
		this.sqlTimeStamp = sqlTimeStamp;
	}
	public DateMappingDTO() {
		super();
	}
	public DateMappingDTO(LocalDateTime localDateTime, Timestamp sqlTimeStamp) {
		super();
		this.localDateTime = localDateTime;
		this.sqlTimeStamp = sqlTimeStamp;
	}
	@Override
	public String toString() {
		return "DateMappingDTO [localDateTime=" + localDateTime + ", sqlTimeStamp=" + sqlTimeStamp + "]";
	}
	
	
	
}


