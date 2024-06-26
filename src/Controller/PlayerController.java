package Controller;

import DomainObjects.PlayerDomainObject;
import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.request.GetPlayerDetailsRequest;
import restService.response.PlayerResponse;

public class PlayerController {

    // CREATING NEW PLAYER - Story 1
    // request is registerplayerrequest.java
    // reponse is playerreponse.java
    // test is playerregistrationtest.java
    public static PlayerResponse registerPlayer(RegisterPlayerRequest request) {
        try {
            
            PlayerDomainObject domainToCreate = new PlayerDomainObject(request);
            PlayerDomainObject domainCreated = PlayerModel.RegisterPlayer(domainToCreate); // is this supposed to be add
                                                                                           // player method????

            PlayerResponse response = new PlayerResponse(domainCreated.GetId(), domainCreated.GetUsername());
            return response;
            // then save the player to the player array list

        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage());
            return response;
        }
    }

    // GETTING PLAYER DETAILS - STORY 6 - also edit PlayerResponse.java
    // request is getplayerdetailsrequest.java
    // reponse is playerreponse.java
    // test is ___.java
    public static PlayerResponse getPlayerDetails(GetPlayerDetailsRequest request) {

        try {

            // validate request details in playermodel.validateplayer method, only getting
            // the playerId for the request, so only validating the playerId
            // so first pass request to be a playerdomain object -> then can call the
            // validate player method in model

            PlayerDomainObject domainToCheck = new PlayerDomainObject(request);
            PlayerDomainObject domainExists = PlayerModel.ExistingPlayer(domainToCheck);

            PlayerResponse response = new PlayerResponse(domainExists.GetId(), domainExists.GetUsername(),
                    domainExists.GetGamesPlayed(), domainExists.GetGamesWon(), domainExists.GetGamesLost());
            return response;

        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage()); // cannot find x player id details
            return response;
        }
    }
}
