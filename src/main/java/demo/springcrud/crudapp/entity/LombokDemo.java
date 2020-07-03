package demo.springcrud.crudapp.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor // For selected type of constructor, to select, make them not null or it only considers the fields that are non-static and final
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NonNull
public @Data class LombokDemo {
	
	private int id;
//	@NonNull
	private final String firstName;
//	@NonNull
	private final String lastName;
	private String email;
	
	public static void main(String[] args) throws IOException {
	
	@Cleanup InputStream in = new FileInputStream(args[0]);
	@Cleanup OutputStream out = new FileOutputStream(args[1]);
	
	}
}
