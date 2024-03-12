package clone.copycat.Moviehungry.Tickets.Mappers;

import clone.copycat.Moviehungry.Theather.TheatersDAO;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketBookingDTO;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketsDTO;
import clone.copycat.Moviehungry.Tickets.TicketsDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketsMapper {
    public TicketsDTO TicketsDAO_TicketsDTO(TicketsDAO ticketsDAO);
    public TicketBookingDTO TicketsDAO_TicketBookingDTO(TicketsDAO ticketsDAO);
    public TicketsDAO TicketsDTO_TicketDAO(TicketsDTO ticketsDTO);
    public TicketsDAO TicketsDAO_TicketBookingDTO(TicketBookingDTO ticketBookingDTO);


}
