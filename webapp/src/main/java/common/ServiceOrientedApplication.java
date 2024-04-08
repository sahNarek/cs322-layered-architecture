package common;

import org.h2.tools.Server;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import common.ServiceOrientedApplication;

import java.sql.SQLException;

@Configuration
@EntityScan(basePackages = {"am.cs322.model" ,"banking.model"})
public class ServiceOrientedApplication {}