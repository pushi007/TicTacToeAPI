package com.tictactoe.api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tictactoe.api.service.GameService;

@Service("userService")
@Transactional
public class GameServiceImpl implements GameService {

}
