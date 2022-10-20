package com.coe.trackvg.controller;

import com.coe.trackvg.model.view.CreateUserView;
import com.coe.trackvg.model.view.UpdateUserView;
import com.coe.trackvg.model.view.UserView;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserController {

  @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserView> getUser(final int userId) {

    return ResponseEntity.ok(UserView.builder().build());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createUser(
      @Valid @RequestBody final CreateUserView createUserView) {

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> updateUser(
      @PathVariable final int userId,
      @Valid @RequestBody final UpdateUserView updateUserView) {

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{userId}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable final int userId) {

    return ResponseEntity.noContent().build();
  }

}
